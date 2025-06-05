import counter.Ticket;
import parking.ParkingSpotType;
import payment.UpiPaymentStratergy;
import vehicle.Car;
import vehicle.Vehicle;

import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle1 = new Car("ABC");
        Vehicle vehicle2 = new Car("DEF");
        ParkingLot parkingLot = ParkingLot.getInstance(6,5);
        AtomicReference<Ticket> ticket1 = new AtomicReference<>();
        Thread t1 = new Thread(()->{
            try{
                ticket1.set(parkingLot.findBooking(vehicle1, ParkingSpotType.COMPACT));
            }catch (Exception e){
                System.out.println("Get the Ticket");
            }
        });
        t1.start();
        try {
            t1.join();
        }catch (Exception exp){

        }


        parkingLot.removeMyVehicle(ticket1.get(), new UpiPaymentStratergy());


    }
}