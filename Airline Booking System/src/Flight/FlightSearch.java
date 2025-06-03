package Flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {
    private List<Flight> flights;

    public FlightSearch() {
        this.flights = new ArrayList<Flight>();
    }

    public List<Flight> searchFlight(String source, String destination, LocalDate date){

        return flights.stream()
                .filter(flight -> flight.getSource().equalsIgnoreCase(source)
                        && flight.getDestination().equalsIgnoreCase(destination)
                        && flight.getDepartureTime().toLocalDate().equals(date))
                .collect(Collectors.toList());


    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }
}
