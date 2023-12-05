package edu.neu.csye7374;

public class MicrosoftStockFactoryGoF implements StockFactory {
    @Override
    public Stock getStock() {
        return new MicrosoftStock();
    }
}
