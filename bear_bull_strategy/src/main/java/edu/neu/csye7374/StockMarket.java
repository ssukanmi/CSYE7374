package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockMarket {

    List<Tradable> stocks = null;
    private static StockMarket instance;

    private StockMarket() {
        instance = null;
        stocks = new ArrayList<>();
    }
    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    private TradeStrategy1 tradeStrategy1(Tradable stock) {
        switch (stock.marketCap()) {
            case SMALL:
                return new SmallCapTradeStrategy();
            case MEDIUM:
                return new MidCapTradeStrategy();
            case LARGE:
                return new LargeCapTradeStrategy();
        }
        return null;
    }

    private TradeStrategy tradeStrategy(Tradable stock) {
        switch (stock.stockSector()) {
            case ENERGY:
                return new EnergyStockTradeStrategy();
            case TECHNOLOGY:
                return TechStockTradeStrategyEagerSingleton.instance;
            case HEALTHCARE:
                return HealthStockTradeStrategyLazySingleton.getInstance();
        }
        return null;
    }

    // Add stock object
    public void addStock(Stock stock) {
        System.out.println("Adding stock " + stock.getName() + " to the stock market");
        this.stocks.add(stock);
    }

//    // Trade stock object
//    public void tradeStock(String stock, double bid) {
//        System.out.println("Trading stock " + stock + "for bid $" + bid + " on the stock market");
//        Iterator stockArr = stocks.iterator();
//        while (stockArr.hasNext()) {
//            Stock s = (Stock) stockArr.next();
//            if (s.getName().equals(stock)) {
//                s.setBid(bid);
//                continue;
//            }
//        }
//    }

//    // Trade stock object
//    public void tradeStock1(String stock, double bid) {
//        System.out.println("Trading " + stock + " stock for bid $" + bid + " on the stock market");
//        Iterator stockArr = stocks.iterator();
//        while (stockArr.hasNext()) {
//            Stock s = (Stock) stockArr.next();
//            if (s.getName().equals(stock)) {
//                TradeStrategy1 strategy = tradeStrategy1(s);
//                double brokerFee = strategy.calculateFee(bid);
//                double adjustedBid = bid - brokerFee;
//                s.setBid(adjustedBid);
//                System.out.println("Bid successfully placed for: $ " + bid + "\nFinal Amount: $ " +
//                        adjustedBid + "\nApplied Broker Fee: $ " + brokerFee + "\n");
//                continue;
//            }
//        }
//    }

    // Trade stock object
    public void tradeStock(String stock, double bid) {
        // System.out.println("Trading " + stock + " stock for bid $" + bid + " on the stock market");
        Iterator stockArr = stocks.iterator();
        while (stockArr.hasNext()) {
            Stock s = (Stock) stockArr.next();
            if (s.getName().equals(stock)) {
                s.setBid(bid);
            }
        }
    }

    // Remove stock object
    public void removeStock(String stock) {
        Iterator stockArr = stocks.iterator();
        while (stockArr.hasNext()) {
            Stock s = (Stock) stockArr.next();
            if (s.getName().equals(stock)) {
                stockArr.remove();
                System.out.println("Removed stock " + stock + " from the stock market");
                continue;
            }
        }
    }

    // Show all stocks traded on this market
    public void showAllStocks() {
        System.out.println("=== All Stocks === ");
        for (Tradable stock : this.stocks) {
            System.out.println(stock.toString());
        }
    }

    public static void demo() {
        // Get StockMarket instance
        StockMarket stockMarket = StockMarket.getInstance();

        //Get Stock Factory instances
        StockFactory netflixStockFactoryGoFAndLazySingleton = NetflixStockFactoryGoFAndLazySingleton.getInstance();
        StockFactory spotifyStockFactoryGoFAndEagerSingleton = SpotifyStockFactoryGoFAndEagerSingleton.instance;
        StockFactory amazonStockFactoryGoF = new AmazonStockFactoryGoF();
        StockFactory cvsStockFactoryGoF = new CVSStockFactoryGoF();
        StockFactory chevronStockFactoryGoF = new ChevronStockFactoryGoF();
        StockFactory microsoftStockFactoryGoF = new MicrosoftStockFactoryGoF();

        //Get Stock objects from factory instances
        Stock netflixStock = netflixStockFactoryGoFAndLazySingleton.getStock();
        Stock spotifyStock = spotifyStockFactoryGoFAndEagerSingleton.getStock();
        Stock amazonStock = amazonStockFactoryGoF.getStock();
        Stock cvsStock = cvsStockFactoryGoF.getStock();
        Stock chevronStock = chevronStockFactoryGoF.getStock();
        Stock microsoftStock = microsoftStockFactoryGoF.getStock();

        //Adding stocks to stock market
        stockMarket.addStock(netflixStock);
        stockMarket.addStock(spotifyStock);
        stockMarket.addStock(amazonStock);
        stockMarket.addStock(cvsStock);
        stockMarket.addStock(chevronStock);
        stockMarket.addStock(microsoftStock);

        //Showing all stocks
        stockMarket.showAllStocks();

        //Removing Amazon stock from stock market
        stockMarket.removeStock("AMZN");
        stockMarket.removeStock("NFLX");
        stockMarket.removeStock("SPOT");
        stockMarket.removeStock("CVX");

        //Showing all stocks again
        stockMarket.showAllStocks();

        //Trading stocks
        stockMarket.tradeStock("CVS", 37.88);
        stockMarket.tradeStock("MSFT", 37.88);
        stockMarket.showAllStocks();
        stockMarket.tradeStock("CVS", 75.75);
        stockMarket.tradeStock("MSFT", 75.75);
        stockMarket.showAllStocks();
        stockMarket.tradeStock("CVS", 113.63);
        stockMarket.tradeStock("MSFT", 113.63);
        stockMarket.showAllStocks();
        stockMarket.tradeStock("CVS", 170.44);
        stockMarket.tradeStock("MSFT", 170.44);
        stockMarket.showAllStocks();
        stockMarket.tradeStock("CVS", 255.65);
        stockMarket.tradeStock("MSFT", 255.65);
        stockMarket.showAllStocks();
        stockMarket.tradeStock("CVS", 383.48);
        stockMarket.tradeStock("MSFT", 383.48);
        stockMarket.showAllStocks();
    }
}
