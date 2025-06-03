public class Seat {
    private final int seatId;
    private int seatNumber;
    private int row;
    private SeatCategory seatCategory;

    public Seat(int seatId, int seatNumber, int row, SeatCategory seatCategory) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.row = row;
        this.seatCategory = seatCategory;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }
}
