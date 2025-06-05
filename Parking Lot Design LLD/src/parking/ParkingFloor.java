package parking;

import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private final int floorNumber;
    private List<ParkingSpot> parkingSpotList;
    private final int maxSize;

    public ParkingFloor(int maxSize,int floorNumber){
        this.parkingSpotList = new ArrayList<>();
        this.maxSize = maxSize;
        this.floorNumber = floorNumber;
        initilizeParkingFloor();

    }

    private void initilizeParkingFloor() {
        for(int i=0;i<maxSize/2;i++){
            parkingSpotList.add(new BikeParkingSpot(i+1, 10,5));
        }
        for(int i=((maxSize/2)+1);i<maxSize;i++){
            parkingSpotList.add(new CarParkingSpot(i+1,20,10));
        }
    }
    public synchronized ParkingSpot findParkingSpot(Vehicle vehicle, ParkingSpotType parkingSpotType){
        for(int i=0;i<maxSize;i++){
            if(parkingSpotList.get(i).parkingSpotType == parkingSpotType && parkingSpotList.get(i).parkingStatus==ParkingStatus.AVAILABLE){
                return parkingSpotList.get(i);
            }
        }
        return null;
    }

}
