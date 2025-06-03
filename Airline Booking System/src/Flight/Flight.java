package Flight;

import AirCraft.Aircraft;
import Seat.Seat;

import java.time.LocalDateTime;
import java.util.*;

public class Flight {
    private final String flightNumber;
    private final String source;
    private final String destination;
    private final LocalDateTime arrivalTime;
    private final LocalDateTime departureTime;
    private final FlightStatus status;
    private final Aircraft aircraft;
    private final Map<String, Seat> seats;
    private final List<Seat> availableSeats;


    public Flight( String source, String destination, LocalDateTime arrivalTime, LocalDateTime departureTime,  Aircraft aircraft) {
        this.flightNumber = UUID.randomUUID().toString();
        this.source = source;
        this.destination = destination;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.status = FlightStatus.ON_TIME;
        this.aircraft = aircraft;
        this.seats = new HashMap<String, Seat>();
        this.availableSeats = new ArrayList<Seat>();
    }

    public synchronized void reserveSeat(String seatNumer){
        Seat  seat = seats.get(seatNumer);
        seat.reserve();
    }

    public synchronized void releaseSeat(String seatNumer){
        Seat  seat = seats.get(seatNumer);
        seat.relese();
    }
    public synchronized boolean isSeatAvailable(String seatNumber){
        Seat  seat = seats.get(seatNumber);
        return seat!=null && !seat.isBooked();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}
