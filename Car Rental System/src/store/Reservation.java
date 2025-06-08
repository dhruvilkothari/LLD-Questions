package store;

import user.User;
import vehicle.Vehicle;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private final String id;
    private final Vehicle vehicle;
    private Status status;
    private final User user;
    private final LocalDate  bookingDate;
    private LocalDate  returnDate;
    private double price;


    public  Reservation(Vehicle vehicle, User user, LocalDate bookingDate, LocalDate returnDate, double price) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.user = user;
        this.bookingDate = bookingDate;
        this.returnDate = returnDate;
        this.price = price;
        this.status = Status.RENTED;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
