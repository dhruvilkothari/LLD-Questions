import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class RentalStore {
    private int id;
    private String name;
    private Location location;
    private HashMap<String, Vehicle> vehicles;
    private HashMap<String, Reservation> reservations;
    private PaymentStratergy paymentStratergy;

    public RentalStore(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.vehicles = new HashMap<>();
        reservations = new HashMap<>();
        paymentStratergy = null;
    }
    public int getId(){
        return id;
    }
    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getRegistrationNumber(), vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle.getRegistrationNumber());
    }
    public String  getName() {
        return name;
    }
    public HashMap<String, Reservation> getReservations() {
        return reservations;
    }
    public Location getLocation() {
        return location;
    }

    public boolean addReservation(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.CONFIRMED);
        reservations.put(reservation.getVehicle().getRegistrationNumber(),reservation);
        return true;
    }

    public boolean canMakeReservation(Vehicle vehicle, Date bookingDate, Date endingDate) {
        return vehicle.isAvailble();
    }
    public void setPaymentStratergy(PaymentStratergy paymentStratergy){
        this.paymentStratergy = paymentStratergy;
    }
    public void makePayment(Reservation reservation, PaymentStratergy  paymentStratergy){
        int amount = reservation.getVehicle().getBasePrice() * (reservation.getEndingDate().getDate() - reservation.getBookingDate().getDate());
        paymentStratergy.pay(amount);
    }
}
