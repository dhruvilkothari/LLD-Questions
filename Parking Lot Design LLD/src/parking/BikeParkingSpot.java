package parking;

public class BikeParkingSpot extends ParkingSpot{
    public BikeParkingSpot(int spotNumber,int basePrice,int pricePerHour) {
        super(spotNumber, ParkingSpotType.COMPACT, basePrice,pricePerHour);
    }
}
