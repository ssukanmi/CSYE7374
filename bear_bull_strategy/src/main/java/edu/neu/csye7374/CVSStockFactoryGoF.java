package edu.neu.csye7374;

public class CVSStockFactoryGoF implements StockFactory {
    @Override
    public Stock getStock() {
        return new CVSStock();
    }
}
