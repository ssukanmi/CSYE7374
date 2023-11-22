package edu.neu.csye7374;

public class NetflixStockFactoryGoF implements StockFactory {
    @Override
    public Stock getStock() {
        return new NetflixStock();
    }
}
