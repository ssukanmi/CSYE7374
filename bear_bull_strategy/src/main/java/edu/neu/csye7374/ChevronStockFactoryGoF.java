package edu.neu.csye7374;

public class ChevronStockFactoryGoF implements StockFactory {
    @Override
    public Stock getStock() {
        return new ChevronStock();
    }
}
