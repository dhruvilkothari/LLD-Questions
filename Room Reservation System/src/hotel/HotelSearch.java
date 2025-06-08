package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelSearch {
    private List<Hotel> hotelList;

    public HotelSearch() {
        this.hotelList = new ArrayList<>();
    }
    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
    }
    public List<Hotel> searchHotels(String city){
        return hotelList.stream().filter(hotel -> hotel.getCity().equals(city)).toList();
    }




}
