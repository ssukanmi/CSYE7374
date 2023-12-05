package edu.neu.csye7374;

public class MidCapTradeStrategy implements TradeStrategy1 {
    @Override
    public double calculateFee(double bid) {
        if (bid >= 0 && bid <= 100) {
            return bid * 0.025;
        } else if (bid >= 100 && bid <= 1000) {
            return bid * 0.035;
        }
        return bid * 0.045;
    }
}
