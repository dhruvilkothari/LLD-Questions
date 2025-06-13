public class Bidder implements Collegues{
    private String name;
    private int lastBidAmount;
    private AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        this.lastBidAmount = 0;
    }

    @Override
    public void placeBidAmount(int amount) {

        boolean placed = auctionMediator.placeBid(this, amount);
        if(placed)
            this.lastBidAmount = amount;
    }

    @Override
    public void receiveBidAmount(int amount) {

        System.out.println("Bidder " + name + " received bid amount: " + amount);

    }

    @Override
    public String getName() {
        return name;
    }
}
