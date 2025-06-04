import counter.Ticket;
import parking.ParkingFloor;
import payment.PaymentProcessor;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private PaymentProcessor paymentProcessor;
    private List<ParkingFloor> parkingFloors;
    private HashMap<Vehicle, Ticket> ticketHashMap;
    private int floors;
    private final static Object lock = new Object();

    private ParkingLot(int maxSize,int floors){
        this.floors = floors;
        paymentProcessor = new PaymentProcessor(null);
        parkingFloors = new ArrayList<>();
        ticketHashMap = new HashMap<>();
        initParkingLot(maxSize);

    }
    public static ParkingLot getInstance(int maxSize,int floors){
        synchronized (lock){
            if(instance == null){
                instance = new ParkingLot(maxSize,floors);
            }
        }
        return instance;
    }

    private void initParkingLot(int maxSize) {
        for(int i=1;i<=floors;i++){
            parkingFloors.add(new ParkingFloor(maxSize,i));
        }
    }
}
