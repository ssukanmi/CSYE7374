package edu.neu.csye7374;

public abstract class Tradable0 implements Tradable {

    private int metric;
    private double price;
    private double bid;

    public void setBid(double bid) {
        if (bid > this.bid) {
            this.bid = bid;
        }
    }

    public int getMetric() {
        metric = (int) ((bid - price) / price ) * 100;
        return metric;
    }

}
