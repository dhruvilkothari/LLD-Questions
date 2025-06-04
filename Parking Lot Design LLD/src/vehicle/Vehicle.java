package vehicle;

public abstract class Vehicle {
    public final String licenseNumber;

    public Vehicle(String licenseNumber){
        this.licenseNumber = licenseNumber;
    }
    public String getLicenseNumber(){
        return this.licenseNumber;
    }

}
