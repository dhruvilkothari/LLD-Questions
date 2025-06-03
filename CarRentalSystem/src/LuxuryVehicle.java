public class LuxuryVehicle extends Vehicle{
    public LuxuryVehicle(String registrationNumber, VehicleType vehicleType, boolean isAvailble, int basePrice) {
        super(registrationNumber, vehicleType, isAvailble, basePrice);
    }

    public int calculatePrice(int days){
        return days*getBasePrice();
    }



}
