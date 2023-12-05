package edu.neu.csye7374;

public interface TradeStrategy {
    String name = null;
    String getName();
    MarketStrategyAlgorithm marketAlgorithm = null;
    double calculateFee(double bid);
    double placeBid(double bid);
}
