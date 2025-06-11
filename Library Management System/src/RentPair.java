import java.time.LocalDate;

public class RentPair {
    private final User user;
    private final Book book;
    private final LocalDate rentDate;
    private LocalDate returnDate;


    public RentPair(User user, Book book, LocalDate rentDate, LocalDate returnDate) {
        this.user = user;
        this.book = book;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
