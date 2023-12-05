package edu.neu.csye7374;

public interface MarketStrategyAlgorithm {
    double getDividendAllocation(double bid);
    double getGrowthAllocation(double bid);
}
