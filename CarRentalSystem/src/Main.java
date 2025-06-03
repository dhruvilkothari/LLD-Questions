import java.util.Date;

public class Main {
    public static void main(String[] args) {

        CarRentalSystem carRentalSystem = CarRentalSystem.getInstance();
        RentalStore rentalStore = new RentalStore(1, "Rental Store 1", new Location( "Location 1"));
        carRentalSystem.addRentalStore(rentalStore);
        Vehicle vehicle1 = new EconomicalVehicle("KA-01-1234", VehicleType.ECONOMICAL, true,100);
        Vehicle vehicle2= new EconomicalVehicle("KA-01-1234", VehicleType.ECONOMICAL, true,100);
        rentalStore.addVehicle(vehicle1);
        rentalStore.addVehicle(vehicle2);
        User user = new User( "User 1");
        boolean isReservationSuccessful = carRentalSystem.makeReservation(
                rentalStore,
                vehicle1,
                user,
                new Date(),
                new Date(System.currentTimeMillis() + 5L * 24 * 60 * 60 * 1000)
        );
        if(isReservationSuccessful){
            System.out.println("Reservation successful");
        }else{
            System.out.println("Reservation failed");
        }
        carRentalSystem.makePayment(rentalStore,vehicle1,new CardPaymentStratergy());


    }
}