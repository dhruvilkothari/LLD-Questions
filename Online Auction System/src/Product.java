import java.util.UUID;

public class Product {
    private final String  id;
    private final String name;
    private final int basePrice;
    private int finalPrice;
    private Bidder winnerBidder;


    public Product( String name, int basePrice, int finalPrice) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.basePrice = basePrice;
        this.finalPrice = finalPrice;
        this.winnerBidder = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void setWinnerBidder(Bidder winnerBidder) {
        this.winnerBidder = winnerBidder;
    }

    public Bidder getWinnerBidder() {
        return winnerBidder;
    }
}
