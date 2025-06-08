import booking.BookingManager;
import payment.UpiPaymentStratergy;
import store.RentalStore;
import store.Reservation;
import user.User;
import vehicle.Category;
import vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("DHRUVIL1", "k1@gmail.com");
        User user2 = new User("DHRUVIL2", "k2@gmail.com");

        RentalStore rentalStore = new RentalStore("7 AhinsaPuriFatehPura");
        Vehicle v1 = new Vehicle("1", "ABC", Category.LUXURY, "RED","BMW", 100);
        Vehicle v2 = new Vehicle("2", "XYZ", Category.LUXURY, "RED", "TOYOTA", 100);
        Vehicle v3 = new Vehicle("3", "MNO", Category.LUXURY, "RED", "MARUTI", 100);
        Vehicle v4 = new Vehicle("4", "PQR", Category.LUXURY, "RED", "JAGUAR", 100);
        rentalStore.addVehicle(v1);
        rentalStore.addVehicle(v2);
        rentalStore.addVehicle(v3);
        rentalStore.addVehicle(v4);

        BookingManager bookingManager = BookingManager.getInstance();
        Thread t1 = new Thread(() -> {
            Reservation reservation = bookingManager.reserveVehicle(v1, user1, LocalDate.now(), LocalDate.now().plusDays(10), rentalStore);
        });
        Thread t2 = new Thread(() -> {
            Reservation reservation = bookingManager.reserveVehicle(v1, user2, LocalDate.now(), LocalDate.now().plusDays(10), rentalStore);
        });
        t1.start();
        t2.start();





    }
}