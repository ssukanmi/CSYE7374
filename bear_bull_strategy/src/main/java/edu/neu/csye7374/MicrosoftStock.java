package edu.neu.csye7374;

public class MicrosoftStock extends Stock{

    public MicrosoftStock() {
        this.setName("MSFT");
        this.setDescription("Microsoft Corporation is an American multinational technology company with headquarters in Redmond, Washington.");
        this.setPrice(369.14);
        this.setTradeStrategy(TechStockTradeStrategyEagerSingleton.instance);
    }

    @Override
    public MarketCap marketCap() {
        return MarketCap.LARGE;
    }

    @Override
    public StockSector stockSector() {
        return StockSector.TECHNOLOGY;
    }
}
