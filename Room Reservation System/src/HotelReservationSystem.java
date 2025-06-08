import hotel.*;
import payment.PaymentProcessor;
import payment.UpiPaymentStratergy;
import user.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationSystem {
    private static HotelReservationSystem instance;
    private List<Hotel> hotelList;
    private HotelSearch hotelSearch;
    private BookingManager bookingManager;
    private PaymentProcessor paymentProcessor;
    public HotelReservationSystem() {
        this.hotelList = new ArrayList<>();
        this.hotelSearch = new HotelSearch();
        this.bookingManager = BookingManager.getInstance();
        paymentProcessor = new PaymentProcessor(new UpiPaymentStratergy());

    }

    public static HotelReservationSystem getInstance() {
        if (instance == null) {
            instance = new HotelReservationSystem();
        }
        return instance;
    }
    public void addHotel(Hotel hotel) {
        hotelSearch.addHotel(hotel);
        hotelList.add(hotel);
    }
    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public Reservation bookRoom(User user, Hotel hotel, Room room, LocalDate checkIn, LocalDate checkOut) {
        synchronized (room){
            if(room.getStatus()!=RoomStatus.AVAILABLE ){
                throw new RuntimeException("Room is not available");
            }
            long days = ChronoUnit.DAYS.between(checkIn, checkOut);
            double amount = days * room.getPricePerDay();


            try {
                paymentProcessor.processPayment(amount);

            }catch (Exception exp){
                System.out.println(exp.getMessage());
            }

            Reservation reservation = bookingManager.bookRoom(user,hotel,room,checkIn,checkOut);
            if(reservation==null){
                throw new RuntimeException("Room is not available");
            }
            return reservation;

        }

    }
    public List<Hotel> searchHotels(String city) {
        return hotelSearch.searchHotels(city);
    }
    public void displayRooms(Hotel hotel) {
        hotel.displayRooms();
    }


}
