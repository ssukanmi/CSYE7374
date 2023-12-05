package edu.neu.csye7374;

public class CVSStock extends Stock{

    public CVSStock() {
        this.setName("CVS");
        this.setDescription("CVS Health Corporation is an American retail pharmacy and health care company headquartered in Woonsocket, Rhode Island.");
        this.setPrice(68.52);
        this.setTradeStrategy(HealthStockTradeStrategyLazySingleton.getInstance());
    }

    @Override
    public MarketCap marketCap() {
        return MarketCap.SMALL;
    }

    @Override
    public StockSector stockSector() {
        return StockSector.HEALTHCARE;
    }
}
