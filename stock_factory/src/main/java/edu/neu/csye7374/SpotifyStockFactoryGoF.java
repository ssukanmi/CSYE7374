package edu.neu.csye7374;

public class SpotifyStockFactoryGoF implements StockFactory {
    @Override
    public Stock getStock() {
        return new SpotifyStock();
    }
}
