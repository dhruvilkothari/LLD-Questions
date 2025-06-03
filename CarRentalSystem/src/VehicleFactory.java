public class VehicleFactory {

    public Vehicle createVehicle(String type, String registrationNumber, boolean isAvailble, int basePrice) {
        if (type.equalsIgnoreCase("LUXURY")) {
            return new LuxuryVehicle(registrationNumber, VehicleType.LUXURY, isAvailble, basePrice);
        } else if (type.equalsIgnoreCase("ECONOMICAL")) {
            return new EconomicalVehicle(registrationNumber, VehicleType.ECONOMICAL, isAvailble, basePrice);
        }
        else {
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }

}
