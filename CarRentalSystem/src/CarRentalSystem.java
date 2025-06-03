import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarRentalSystem {
    public static CarRentalSystem instance;
    private List<RentalStore> rentalStores ;
    private ReservationController reservationController;

    private CarRentalSystem() {
        this.rentalStores = new ArrayList<>();
        this.reservationController = new ReservationController();
    }
    public static CarRentalSystem getInstance() {
        if (instance == null) {
            instance = new CarRentalSystem();

        }
        return instance;
    }
    public void addRentalStore(RentalStore rentalStore){
        rentalStores.add(rentalStore);
    }
    public void removeRentalStore(RentalStore rentalStore){
        rentalStores.remove(rentalStore);
    }
    public boolean makeReservation(RentalStore rentalStore, Vehicle vehicle, User user, Date  bookingDate, Date endingDate){
        return reservationController.addReservation(rentalStore, vehicle, user, bookingDate, endingDate);
    }

    public void makePayment(RentalStore rentalStore, Vehicle vehicle1, CardPaymentStratergy cardPaymentStratergy) {
        Reservation reservation = rentalStore.getReservations().get(vehicle1.getRegistrationNumber());
        rentalStore.makePayment(reservation,cardPaymentStratergy);
        reservationController.updateReservation(rentalStore, vehicle1, ReservationStatus.COMPLETED);
    }
}
