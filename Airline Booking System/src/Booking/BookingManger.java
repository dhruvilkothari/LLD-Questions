package Booking;

import Flight.Flight;
import Passenger.Passenger;
import Seat.Seat;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class BookingManger {
    private static BookingManger instance;

    private HashMap<String, Booking> bookings;

    private final Object lock = new Object();

    private BookingManger() {
        bookings = new HashMap<>();
    }
    public static BookingManger getInstance() {
        if (instance == null) {
            synchronized (BookingManger.class) {
                if (instance == null) {
                    instance = new BookingManger();
                }
            }
        }
        return instance;
    }

    public Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price){
        String bookingNumber = UUID.randomUUID().toString();
//        seat.lockSeat();
        if(seat.isBooked()){
//            seat.unLockSeat();
            throw new RuntimeException("Seat is already booked");

        }
        Booking booking = new Booking(flight, passenger, seat, price);

        synchronized (lock){
            bookings.put(bookingNumber, booking);
        }
        System.out.println("Booking created successfully: " + bookingNumber);
        return booking;
    }
    public void cancelBooking(String bookingNumber){
        synchronized (lock){
            if(bookings.containsKey(bookingNumber)){
                Booking booking = bookings.get(bookingNumber);
                booking.cancelBooking();
//                bookings.remove(bookingNumber);
                System.out.println("Booking cancelled successfully: " + bookingNumber);
            }else{
                System.out.println("Booking not found: " + bookingNumber);
            }
        }
    }

}
