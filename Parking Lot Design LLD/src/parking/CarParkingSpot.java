package parking;

public class CarParkingSpot extends ParkingSpot{
    public CarParkingSpot(int spotNumber,int basePrice,int pricePerHour) {
        super(spotNumber, ParkingSpotType.MEDIUM, basePrice,pricePerHour);
    }
}
