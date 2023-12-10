package edu.neu.csye7374;

public class LargeCapTradeStrategy implements TradeStrategy {
    @Override
    public double calculateBrokerFee(double bid) {
        if (bid >= 0 && bid <= 100) {
            return bid * 0.01;
        } else if (bid >= 100 && bid <= 1000) {
            return bid * 0.02;
        }
        return bid * 0.03;
    }
}
