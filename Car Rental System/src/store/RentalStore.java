package store;

import payment.PaymentProcessor;
import payment.PaymentStratergy;
import payment.UpiPaymentStratergy;
import user.User;
import vehicle.Status;
import vehicle.Vehicle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.UUID;

public class RentalStore {
    private String id;
    private String address;
    private HashMap<String, Vehicle> vehicles;
    private HashMap<Vehicle, Reservation> reservations;
    private PaymentProcessor paymentProcessor ;

    public RentalStore( String address) {
        this.id = UUID.randomUUID().toString();
        this.address = address;
        this.vehicles = new HashMap<>();
        this.reservations = new HashMap<>();
        paymentProcessor = new PaymentProcessor();
    }
    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }
    private void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle.getId());
    }

    public synchronized Reservation addReservation(Vehicle vehicle, User user, LocalDate bookingDate, LocalDate returnDate) {

        if (returnDate.isBefore(bookingDate)) {
            throw new IllegalArgumentException("Return date cannot be before booking date.");
        }

        long days = ChronoUnit.DAYS.between(bookingDate, returnDate);
        double totalCost = vehicle.getPricePerDay() * days;

        synchronized (vehicle) {
            if(vehicle.getStatus()!= Status.AVAILABLE){
                throw new IllegalArgumentException("Vehicle is not available.");
            }
            Reservation reservation = new Reservation(vehicle, user, bookingDate, returnDate, totalCost);
            reservations.put(vehicle, reservation);
            vehicle.setStatus(Status.BOOKED);
            return reservation;
        }
    }
    public void returnVehicle(Vehicle vehicle, PaymentStratergy paymentStratergy) {
        if(vehicle.getStatus() == Status.AVAILABLE){
            throw new IllegalArgumentException("Vehicle is not rented.");
        }
        synchronized (vehicle) {
            paymentProcessor.setPaymentStratergy(paymentStratergy);
            Reservation reservation = reservations.get(vehicle);
            paymentProcessor.processPayment(reservation.getPrice());
            vehicle.setStatus(Status.AVAILABLE);
            reservations.remove(vehicle);
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HashMap<String, Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(HashMap<String, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public HashMap<Vehicle, Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(HashMap<Vehicle, Reservation> reservations) {
        this.reservations = reservations;
    }
}
