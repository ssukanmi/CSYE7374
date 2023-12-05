package edu.neu.csye7374;

public class HealthStockTradeStrategy implements TradeStrategy {

    private String name;
    private MarketStrategyAlgorithm marketAlgorithm;
    public static final double K_FACTOR = 0.0125;

    public HealthStockTradeStrategy() {
        this.name = "Health Stock Trade Strategy";
        this.marketAlgorithm = new BearMarketStrategyAlgorithm();
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
                + " Using Bear Market Strategy"
                + "\nDividend Allocation: $ " + dividendAllocation
                + "\nGrowth Allocation: $ " + growthAllocation
                + "\nBroker Fee: $ " + fee
                + "\n");
        return adjustedBid;
    }
}
