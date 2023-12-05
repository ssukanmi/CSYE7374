package edu.neu.csye7374;

public class BullMarketStrategyAlgorithm implements MarketStrategyAlgorithm{

    public static final double DIVIDEND_ALLOCATION = 0.1;
    public static final double GROWTH_ALLOCATION = 1 - DIVIDEND_ALLOCATION;

    @Override
    public double getDividendAllocation(double bid) {
        return bid * DIVIDEND_ALLOCATION;
    }

    @Override
    public double getGrowthAllocation(double bid) {
        return bid * GROWTH_ALLOCATION;
    }
}
