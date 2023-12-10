package edu.neu.csye7374;

public class SmallCapTradeStrategy implements TradeStrategy {
    @Override
    public double calculateBrokerFee(double bid) {
        if (bid >= 0 && bid <= 100) {
            return bid * 0.035;
        } else if (bid >= 100 && bid <= 1000) {
            return bid * 0.045;
        }
        return bid * 0.055;
    }
}
