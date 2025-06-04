package counter;

import parking.ParkingSpot;
import vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private ParkingSpot parkingSpot;
    private LocalDateTime parkingTime;
    private Vehicle vehicle;

    public Ticket(ParkingSpot parkingSpot,Vehicle vehicle){
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.parkingTime = LocalDateTime.now();
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(LocalDateTime parkingTime) {
        this.parkingTime = parkingTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
