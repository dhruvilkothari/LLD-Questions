package hotel;

import java.util.UUID;

public class Room {
    private final String id;
    private final int roomNumber;
    private final int floor;
    private Roomtype roomType;
    private RoomStatus status;
    private double pricePerDay;


    public Room(int roomNumber, int floor, Roomtype roomType, RoomStatus status, double pricePerDay) {
        this.id = UUID.randomUUID().toString();
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.roomType = roomType;
        this.status = status;
        this.pricePerDay = pricePerDay;
    }

    public String getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public Roomtype getRoomType() {
        return roomType;
    }

    public void setRoomType(Roomtype roomType) {
        this.roomType = roomType;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void displayInfo() {
        System.out.println("Room ID: " + id);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Floor: " + floor);
        System.out.println("Room Type: " + roomType);
        System.out.println("Status: " + status);
        System.out.println("Price per Day: " + pricePerDay);
    }
}
