import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator{

    private List<Bidder> bidders;
    private final Product product;

    public Auction(Product product){
        bidders = new ArrayList<>();
        this.product = product;
    }




    @Override
    public void addBidder(Bidder bidder) {
        bidders.add(bidder);
    }


    @Override
    public synchronized boolean placeBid(Bidder bidder, int bidAmount) {

        System.out.println("Placing bid for bidder: " + bidder.getName() + " with amount: " + bidAmount);
        if(bidAmount > product.getFinalPrice()){
            product.setFinalPrice(bidAmount);
            product.setWinnerBidder(bidder);
            notifyBidders(bidder);
            return true;
        }
        System.out.println("Bid amount is less than the final price of the product. Bid not placed.");

        return false;
    }
    public void notifyBidders(Bidder placedBidder){
        for(Bidder bidder : bidders){
            if(bidder != placedBidder)
                bidder.receiveBidAmount(product.getFinalPrice());
        }
    }


    public Bidder getWinner(){
        return product.getWinnerBidder();
    }
}
