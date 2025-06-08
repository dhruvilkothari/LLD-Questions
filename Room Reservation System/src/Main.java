import hotel.Hotel;
import hotel.Room;
import hotel.RoomStatus;
import hotel.Roomtype;
import user.User;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HotelReservationSystem hotelReservationSystem = HotelReservationSystem.getInstance();
        User user1 = new User("dk1", "dk1@gmail.com");
        User user2 = new User("dk2", "dk2@gmail.com");

        Room  room1 = new Room(1,1, Roomtype.ECONOMY, RoomStatus.AVAILABLE,1000);
        Room  room2 = new Room(2, 2, Roomtype.LUXURY, RoomStatus.AVAILABLE, 2000);
        Room  room3 = new Room(3, 1, Roomtype.ECONOMY, RoomStatus.AVAILABLE, 1000);

        List<Room> rooms = List.of(room1, room2, room3);

        Hotel  hotel1 = new Hotel("Hotel 1", "City 1", rooms);
        Hotel  hotel2 = new Hotel("Hotel 2", "City 2", rooms);

        hotelReservationSystem.addHotel(hotel1);
        hotelReservationSystem.addHotel(hotel2);
        List<Hotel> hotels = hotelReservationSystem.searchHotels("City 1");


        Thread t1 = new Thread(()->{
            hotelReservationSystem.bookRoom(user1, hotel1, room1, LocalDate.now(), LocalDate.now().plusDays(10));
        },user1.getName());

        Thread t2 = new Thread(()->{
            hotelReservationSystem.bookRoom(user2, hotel1, room1, LocalDate.now(), LocalDate.now().plusDays(10));
        }, user2.getName());
        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
        }catch (Exception exp){
            System.out.println(exp.getMessage());
        }

        hotels.stream().forEach(Hotel::displayRooms);

    }
}