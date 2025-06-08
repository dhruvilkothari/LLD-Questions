package booking;

import payment.PaymentStratergy;
import store.RentalStore;
import store.Reservation;
import user.User;
import vehicle.Status;
import vehicle.Vehicle;

import java.time.LocalDate;

public class BookingManager {
    private static BookingManager instance;

    private BookingManager(){
        System.out.println("BookingManager created");

    }
    public static BookingManager getInstance(){
        if(instance == null){
            instance = new BookingManager();
        }
        return instance;
    }
    public Reservation reserveVehicle(Vehicle vehicle, User user, LocalDate bookingDate, LocalDate returnDate, RentalStore rentalStore){
        Reservation reservation = rentalStore.addReservation(vehicle, user, bookingDate, returnDate);
        if(reservation==null){
            throw new IllegalArgumentException("Vehicle is not available for booking.");
        }
        return reservation;
    }
    public void returnVehicle(Vehicle vehicle, RentalStore rentalStore, PaymentStratergy paymentStratergy){
        if(vehicle.getStatus() == Status.AVAILABLE){
            throw new IllegalArgumentException("Vehicle is not rented.");
        }
        synchronized (vehicle) {
            Reservation reservation = rentalStore.getReservations().get(vehicle);
            rentalStore.returnVehicle(vehicle, paymentStratergy);
        }
    }

}
