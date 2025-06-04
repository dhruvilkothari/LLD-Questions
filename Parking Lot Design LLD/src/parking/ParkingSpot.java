package parking;

import vehicle.Vehicle;

public abstract class ParkingSpot {
     public final int spotNumber;
     public ParkingStatus parkingStatus;
     public Vehicle vehicle;
     public final ParkingSpotType parkingSpotType;
     public final Object lock = new Object();
     public int basePrice;
     public int pricePerHour;

     public ParkingSpot(int spotNumber,ParkingSpotType parkingSpotType, int basePrice,int pricePerHour){
          this.parkingSpotType = parkingSpotType;
          this.spotNumber =spotNumber;
          this.vehicle = null;
          this.parkingStatus = ParkingStatus.AVAILABLE;
          this.pricePerHour = pricePerHour;
          this.basePrice = basePrice;
     }

     public int getSpotNumber() {
          return spotNumber;
     }

     public ParkingStatus getParkingStatus() {
          return parkingStatus;
     }

     public void setParkingStatus(ParkingStatus parkingStatus) {
          this.parkingStatus = parkingStatus;
     }

     public Vehicle getVehicle() {
          return vehicle;
     }

     public void setVehicle(Vehicle vehicle) {
          this.vehicle = vehicle;
     }

     public ParkingSpotType getParkingSpotType() {
          return parkingSpotType;
     }

     public boolean bookSpot(Vehicle vehicle){
          synchronized (lock){
               if(parkingStatus == ParkingStatus.AVAILABLE){
                    this.vehicle =vehicle;
                    parkingStatus = ParkingStatus.OCCUPIED;
                    return true;
               }
          }
          return false;
     }
     public boolean releaseVehicle(){
          synchronized (lock){
               if(parkingStatus == ParkingStatus.OCCUPIED){
                    this.vehicle = null;
                    parkingStatus = ParkingStatus.AVAILABLE;
                    return true;
               }
          }
          return false;
     }

}
