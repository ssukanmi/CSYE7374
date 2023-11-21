package edu.neu.csye7374;

public class AmazonStockFactoryGoF implements StockFactory {
    @Override
    public Stock getStock() {
        return new AmazonStock();
    }
}
