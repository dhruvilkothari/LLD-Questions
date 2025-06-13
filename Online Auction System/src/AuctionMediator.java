public interface AuctionMediator {
    void addBidder(Bidder bidder);
    boolean placeBid(Bidder bidder, int bidAmount);
    void notifyBidders(Bidder placedBidder);
    Bidder getWinner();
}
