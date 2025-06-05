package amount;

import counter.Ticket;
import parking.ParkingSpot;
import vehicle.Vehicle;

import java.time.LocalDateTime;

public class AmountCalculator {
    public static int getAmountForVehicle(Ticket ticket){
        int amount = 0;
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        amount+= parkingSpot.getBasePrice()+ (LocalDateTime.now().getHour()-ticket.getParkingTime().getHour())*parkingSpot.getPricePerHour();
        return amount;
    }
}
