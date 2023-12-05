package edu.neu.csye7374;

public class ChevronStock extends Stock{

    public ChevronStock() {
        this.setName("CVX");
        this.setDescription("Chevron Corporation is an American multinational energy corporation. It is headquartered in San Ramon, California, and active in more than 180 countries.");
        this.setPrice(144.87);
        this.setTradeStrategy(new EnergyStockTradeStrategy());
    }

    @Override
    public MarketCap marketCap() {
        return MarketCap.MEDIUM;
    }

    @Override
    public StockSector stockSector() {
        return StockSector.ENERGY;
    }
}
