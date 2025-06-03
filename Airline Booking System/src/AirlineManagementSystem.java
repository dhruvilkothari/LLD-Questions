import AirCraft.Aircraft;
import Booking.Booking;
import Booking.BookingManger;
import Flight.*;
import Passenger.Passenger;
import Payment.PaymentProcessor;
import Payment.UpiPaymentStratergy;
import Seat.Seat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirlineManagementSystem {
    private final Map<String, Flight> flights;
    private final Map<String, Aircraft> aircrafts;
    private final Map<String, Passenger> passengers;
    private final FlightSearch flightSearch;
    private final BookingManger bookingManager;
    private final PaymentProcessor paymentProcessor;


    public AirlineManagementSystem() {
        this.flights = new HashMap<String, Flight>();
        this.aircrafts = new HashMap<>();
        this.passengers = new HashMap<>();
        this.flightSearch = new FlightSearch();
        this.bookingManager = BookingManger.getInstance();
        this.paymentProcessor = new PaymentProcessor(new UpiPaymentStratergy());
    }
    public Passenger addPassenger(String name, String email) {
        Passenger passenger = new Passenger(name, email);
        passengers.put(passenger.getId(), passenger);
        return passenger;
    }

    public Aircraft addAircraft(String tailNumber, String model, int totalSeats) {
        Aircraft aircraft = new Aircraft(tailNumber, model, totalSeats);
        aircrafts.put(tailNumber, aircraft);
        return aircraft;
    }

    public Flight addFlight(String source, String destination, LocalDateTime departure,
                            LocalDateTime arrival, String aircraftNumber) {
        Aircraft aircraft = aircrafts.get(aircraftNumber);
        Flight flight = new Flight(source, destination, departure, arrival, aircraft);
        flights.put(flight.getFlightNumber(), flight);
        flightSearch.addFlight(flight);
        return flight;
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate date) {
        return flightSearch.searchFlight(source, destination, date);
    }

    public Booking bookFlight(String flightNumber, String passengerId, Seat seatNumbers, double price) {
        Flight flight = flights.get(flightNumber);
        Passenger passenger = passengers.get(passengerId);
       return bookingManager.createBooking(flight, passenger, seatNumbers, price);
    }
//    public void makePayment() {
//        paymentProcessor.processPayment(booking);
//    }
    public void cancelBooking(String bookingId) {
        bookingManager.cancelBooking(bookingId);
    }

}
