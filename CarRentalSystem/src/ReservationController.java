import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ReservationController {

    public ReservationController(){
    }


    public boolean addReservation(RentalStore rentalStore, Vehicle vehicle, User user, Date  bookingDate, Date endingDate){
        boolean isValid = rentalStore.canMakeReservation(vehicle, bookingDate, endingDate);
        if(!isValid){
            return false;

        }
        Reservation reservation = new Reservation((int) (Math.random() * 1000), vehicle, user, bookingDate, endingDate, rentalStore.getLocation(), rentalStore.getLocation(), ReservationStatus.REQUESTED);
        return rentalStore.addReservation(reservation);


    }
    public void updateReservation(RentalStore rentalStore,Vehicle vehicle, ReservationStatus reservationStatus){
                HashMap<String, Reservation> reservations= rentalStore.getReservations();
                if(reservations.containsKey(vehicle.getRegistrationNumber())){
                    reservations.get(vehicle.getRegistrationNumber()).setReservationStatus(reservationStatus);
                }
            }



}
