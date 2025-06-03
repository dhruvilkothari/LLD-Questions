import java.util.Date;

public class Reservation {
    private int id;
    private Vehicle vehicle;
    private User user;
    private Date bookingDate;
    private Date endingDate;
    private Location pickupLocation;
    private Location dropLocation;
    private ReservationStatus reservationStatus;
    public Reservation(int id, Vehicle vehicle, User user, Date bookingDate, Date endingDate, Location pickupLocation, Location dropLocation,ReservationStatus reservationStatus) {
        this.id = id;
        this.vehicle = vehicle;
        this.user = user;
        this.bookingDate = bookingDate;
        this.endingDate = endingDate;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.reservationStatus = reservationStatus;
    }
    public int getId() {
        return id;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public User getUser() {
        return user;
    }
    public Date getBookingDate() {
        return bookingDate;
    }
    public Date getEndingDate() {
        return endingDate;
    }
    public Location getPickupLocation() {
        return pickupLocation;
    }
    public Location getDropLocation() {
        return dropLocation;
    }
    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }
    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
