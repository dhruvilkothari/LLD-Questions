public class Main {
    public static void main(String[] args) {

        Product product = new Product("Laptop", 100, 100);

        AuctionMediator auction = new Auction(product);
        Bidder bidder1 = new Bidder("Bidder1", auction);
        Bidder bidder2 = new Bidder("Bidder2", auction);

        auction.addBidder(bidder1);
        auction.addBidder(bidder2);

        Thread t1 = new Thread(()->{
            auction.placeBid(bidder1, 150);
            auction.notifyBidders(bidder1);
        });

        Thread t2 = new Thread(()->{
            auction.placeBid(bidder2, 200);
            auction.notifyBidders(bidder2);
        });
        Thread t3 = new Thread(()->{
            auction.placeBid(bidder1, 250);
            auction.notifyBidders(bidder1);
        });

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(auction.getWinner().getName());





    }
}