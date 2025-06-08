package vehicle;

import java.util.UUID;

public class Vehicle {
    private String id;
    private String model;
    private String licenseNumber;
    private Category category;
    private String color;
    private Status status;
    private String name;
    private int pricePerDay;


    public Vehicle(String model, String licenseNumber, Category category, String color, String name, int pricePerDay) {
        this.model = model;
        this.licenseNumber = licenseNumber;
        this.category = category;
        this.color = color;
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.status = Status.AVAILABLE;
        this.pricePerDay = pricePerDay;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public int getPricePerDay() {
        return pricePerDay;
    }
    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Category getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }
}
