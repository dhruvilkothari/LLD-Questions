import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Book b1 = new Book("BOOK1", "DK", "DAR1");
        Book b2 = new Book("BOOK2", "DK", "DARK2");

        LibraryManager libraryManager = LibraryManager.getInstance();
        libraryManager.addBook(b1, 1);
        libraryManager.addBook(b2, 10);
        User user1 = new User("DK1", "dk1@gmail.com");
        User user2 = new User("DK2", "dk2@gmail.com");

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(100); // Simulate slight delay
                libraryManager.rentBook(b1, user1, LocalDate.now().minusDays(2));
                System.out.println("T1: Book rented by " + user1.getName());
            } catch (Exception exp) {
                System.out.println("T1 Error: " + exp.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100); // Simulate same delay to make it random
                libraryManager.rentBook(b1, user2, LocalDate.now().minusDays(2));
                System.out.println("T2: Book rented by " + user2.getName());
            } catch (Exception exp) {
                System.out.println("T2 Error: " + exp.getMessage());
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();




        libraryManager.returnBook(b1);


    }
}