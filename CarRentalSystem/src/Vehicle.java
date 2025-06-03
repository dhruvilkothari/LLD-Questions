public abstract class Vehicle {
    private String registrationNumber;
    private VehicleType VehicleType;
    private boolean isAvailble;
    private int basePrice;

    public Vehicle(String registrationNumber, VehicleType vehicleType, boolean isAvailble, int basePrice) {
        this.registrationNumber = registrationNumber;
        VehicleType = vehicleType;
        this.isAvailble = isAvailble;
        this.basePrice = basePrice;
    }

    public String  getRegistrationNumber() {
        return registrationNumber;
    }
    public  VehicleType getVehicleType() {
        return VehicleType;
    }

    public boolean isAvailble() {
        return isAvailble;
    }
    public int getBasePrice() {
        return basePrice;
    }

}
