package hotel;

import user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Hotel {
    private final String id;
    private String name;
    private String city;
    private List<Room> rooms;

    private HashMap<User, Reservation> reservations;

    public Hotel(String name, String city, List<Room> rooms) {
        this.name = name;
        this.city = city;
        this.rooms = rooms;
        this.reservations = new HashMap<>();
        this.id = UUID.randomUUID().toString();
    }
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public HashMap<User, Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(HashMap<User, Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Reservation addReservation(User user, LocalDate checkInDate, LocalDate checkOutDate, Room room){
        synchronized (room){
            if(room.getStatus()!=RoomStatus.AVAILABLE ||room.getStatus()==RoomStatus.UNDER_MAINTENANCE ){
                throw new RuntimeException("Room is not available");
            }

            Reservation reservation = new Reservation(user, this, room,checkInDate, checkOutDate);
            reservations.put(user, reservation);
            room.setStatus(RoomStatus.RESERVED);
            return reservation;
        }
    }

    public void displayRooms() {
        for (Room room : rooms) {
            room.displayInfo();
        }
    }
}
