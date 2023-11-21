package edu.neu.csye7374;

public class NetflixStockFactoryGoFAndLazySingleton implements StockFactory {

    private static NetflixStockFactoryGoFAndLazySingleton instance;

    private NetflixStockFactoryGoFAndLazySingleton() {
        instance = null;
    }

    public static synchronized NetflixStockFactoryGoFAndLazySingleton getInstance() {
        if (instance == null) {
            instance = new NetflixStockFactoryGoFAndLazySingleton();
        }
        return instance;
    }

    @Override
    public Stock getStock() {
        return new NetflixStock();
    }
}
