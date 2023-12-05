package edu.neu.csye7374;

public class TechStockTradeStrategy implements TradeStrategy {

    private String name;
    private MarketStrategyAlgorithm marketAlgorithm;
    public static final double K_FACTOR = 0.02;

    public TechStockTradeStrategy() {
        this.name = "Technology Stock Trade Strategy";
        this.marketAlgorithm = new BullMarketStrategyAlgorithm();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculateFee(double bid) {
        return bid * K_FACTOR;
    }

    @Override
    public double placeBid(double bid) {
        double fee = calculateFee(bid);
        double adjustedBid = bid - fee;
        double dividendAllocation = marketAlgorithm.getDividendAllocation(adjustedBid);
        double growthAllocation = marketAlgorithm.getGrowthAllocation(adjustedBid);
        System.out.println("Bid successfully placed for: $ " + bid
                + " Using Bull Market Strategy"
                + "\nDividend Allocation: $ " + dividendAllocation
                + "\nGrowth Allocation: $ " + growthAllocation
                + "\nBroker Fee: $ " + fee
                + "\n");
        return adjustedBid;
    }
}
