package edu.neu.csye7374;

public class Stock implements Tradable {

    private String name;
    private double price;
    private double bid;
    private String description;
    private int metric;

    @Override
    public void setBid(double bid) {
        if (bid > this.bid) {
            this.bid = bid;
        }
    }

    @Override
    public int getMetric() {
        double newMetric = ((bid - price) / price ) * 100;
        metric = (int) newMetric;
        return metric;
    }

    public String toString() {
        return "==== \n" + name + " Stock \n Current price: $" + price + "\n Current bid: $" +
                bid + "\n Description: " + description + "\n Metric: " + getMetric() + "\n==== \n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
