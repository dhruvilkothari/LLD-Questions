import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final String transactionId;
    private final int amount;
    private final LocalDateTime date;
    private TransactionStatus status;
    private final String source;
    private final String destination;


    public Transaction(int amount, String source, String destination) {
        this.transactionId = UUID.randomUUID().toString();
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.status = TransactionStatus.PENDING;
        this.source = source;
        this.destination = destination;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}
