package edu.neu.csye7374;

public class SpotifyStockFactoryGoFAndEagerSingleton implements StockFactory {

    public static SpotifyStockFactoryGoFAndEagerSingleton instance = new SpotifyStockFactoryGoFAndEagerSingleton();
    private SpotifyStockFactoryGoFAndEagerSingleton() { }

    @Override
    public Stock getStock() {
        return new SpotifyStock();
    }

}
