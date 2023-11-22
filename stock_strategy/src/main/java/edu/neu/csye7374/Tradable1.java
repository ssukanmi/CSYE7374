package edu.neu.csye7374;

public abstract class Tradable1 implements Tradable {

    private double price;
    private double bid;
    private int metric;

    public int getMetric() {
        metric = (int) ((bid - price) / price ) * 100;
        return metric;
    }

}
