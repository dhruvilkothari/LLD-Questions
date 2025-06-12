import payment.CardPaymentStratergy;
import payment.PaymentProcessor;
import payment.UpiPaymentStratergy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LibraryManager {
    private final BookManager  bookManager;
    private PaymentProcessor paymentProcessor;
    private HashMap<String, RentPair> rentPairs;
    private static LibraryManager instance ;
    public static LibraryManager getInstance() {
        synchronized (LibraryManager.class) {
            if (instance == null) {
                instance = new LibraryManager();
            }
            return instance;
        }
    }

    public LibraryManager() {
        bookManager = BookManager.getInstance();
        paymentProcessor = new PaymentProcessor(new UpiPaymentStratergy());
        rentPairs = new HashMap<>();
    }
    public void addBook(Book book, int quantity) {
        bookManager.addBook(book, quantity);
    }
    public boolean rentBook(Book book, User user, LocalDate returnDate) {
        synchronized (book){
            int q = bookManager.getQuantity(book);
            if(q == 0){
                throw new RuntimeException("Book not available");
            }
           boolean  canRent =  bookManager.rentBook(book, user);
            if(canRent){
                RentPair rentPair = new RentPair(user, book, LocalDate.now(), returnDate);
                rentPairs.put(book.getId(), rentPair);
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean returnBook(Book book) {
        synchronized (book){
            RentPair rentPair = rentPairs.get(book.getId());
            if(rentPair == null)return false;
            User user = rentPair.getUser();
            if(!Objects.equals(rentPair.getBook().getId(), book.getId()))return false;

            if(LocalDate.now().isAfter(rentPair.getReturnDate())){
                System.out.println("HOW WOULD YOU LIKE TO PAY \n 1) CARD \n 2) UPI");
                int choice = Integer.parseInt(System.console().readLine());
                if(choice == 1){
                    paymentProcessor.setPaymentStratergy(new CardPaymentStratergy());
                }
                if(choice == 2){
                    paymentProcessor.setPaymentStratergy(new UpiPaymentStratergy());
                }
                paymentProcessor.pay(1000);
            }

            bookManager.returnBook(book, user);
            rentPairs.remove(book.getId());
            return true;
        }
    }

}
