package Booking;

import Flight.Flight;
import Passenger.Passenger;
import Seat.Seat;

import java.util.UUID;

public class Booking {
    private final String bookingId;
    private final Flight flight;
    private final Passenger passenger;
    private final   Seat seat;
    private  BookingStatus  status;
    private final double price;


    public Booking(Flight flight, Passenger passenger, Seat seat, double price) {
        this.bookingId = UUID.randomUUID().toString();
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.status = BookingStatus.CONFIRMED;
        this.price = price;
    }

    public void cancelBooking() {
        this.status = BookingStatus.CANCELLED;
        seat.relese();
    }
    public String getBookingId() {
        return bookingId;
    }


}
