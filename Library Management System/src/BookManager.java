import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class BookManager {
    private static BookManager instance ;
    private HashMap<Book,Integer> books;

    public BookManager() {
        books = new HashMap<>();
    }

    public static BookManager getInstance() {
        synchronized (BookManager.class) {
            if (instance == null) {
                instance = new BookManager();
            }
            return instance;
        }
    }
    public void addBook(Book book, int quantity) {
        if (books.containsKey(book)) {
            quantity += books.get(book);
        }
        books.put(book, quantity);
    }
    public boolean rentBook(Book book, User user) {
        synchronized (book){
            if (books.containsKey(book) && books.get(book) > 0) {
                books.put(book, books.get(book) - 1);
                return true;
            } else {
                System.out.println("Book not available");
                return false;
            }
        }
    }
    public void returnBook(Book book, User user) {
        synchronized (book){
           books.put(book, books.get(book) + 1);
        }
    }
    public int getQuantity(Book book) {
        return books.getOrDefault(book, 0);
    }
}
