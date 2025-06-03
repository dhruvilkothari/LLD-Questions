package Seat;

import java.util.concurrent.locks.Lock;

public class Seat {
    private final String  seatNumber;
    private final SeatType seatType;
    private SeatStatus seatStatus;
    private Object lock = new Object();

    public Seat(String seatNumber, SeatType seatType){
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    public synchronized void lockSeat(){
        synchronized (lock){
            if(seatStatus==SeatStatus.AVAILABLE){
                seatStatus = SeatStatus.OCCUPIED;
            }else{
                throw new RuntimeException("Seat is not available");
            }
        }
    }
    public synchronized void unLockSeat(){
        synchronized (lock){
            if(seatStatus==SeatStatus.OCCUPIED){
                seatStatus = SeatStatus.AVAILABLE;
            }else{
                throw new RuntimeException("Seat is not occupied");
            }
        }
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void relese(){
        this.seatStatus = SeatStatus.AVAILABLE;
    }
    public synchronized  boolean  isBooked(){
        return seatStatus.equals(SeatStatus.OCCUPIED);
    }

    public void reserve() {
        if (this.seatStatus.equals(SeatStatus.AVAILABLE)) {
            this.seatStatus = SeatStatus.OCCUPIED;
        } else {
            throw new RuntimeException("Seat is not available");
        }
    }
}
