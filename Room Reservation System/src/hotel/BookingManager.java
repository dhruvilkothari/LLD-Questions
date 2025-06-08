package hotel;

import user.User;

import java.time.LocalDate;

public class BookingManager {
    private static BookingManager bookingManager;

    public BookingManager() {
    }

    public static BookingManager getInstance() {
        if (bookingManager == null) {
            bookingManager = new BookingManager();
        }
        return bookingManager;
    }

    public Reservation bookRoom(User user, Hotel hotel, Room room, LocalDate checkIn, LocalDate checkOut) {
        Reservation reservation = hotel.addReservation(user, checkIn, checkOut,room);
        if(reservation==null){
            throw new RuntimeException("Room is not available");
        }
        return reservation;
    }


}
