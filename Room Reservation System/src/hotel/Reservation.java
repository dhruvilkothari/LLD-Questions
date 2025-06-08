package hotel;

import user.User;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private final String id;
    private  final User user;
    private final Hotel hotel;
    private final Room room;
    private LocalDate  checkInDate;
    private LocalDate checkOutDate;
    private  ReservationStatus status;

    public Reservation(User user, Hotel hotel, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.user = user;
        this.hotel = hotel;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = ReservationStatus.BOOKED;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
