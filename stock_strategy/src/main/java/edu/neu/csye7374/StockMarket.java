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

    private TradeStrategy tradeStrategy(Tradable stock) {
        switch (stock.marketCap()) {
            case SMALL:
                return new SmallCapTradeStrategy();
            case MID:
                return new MidCapTradeStrategy();
            case LARGE:
                return new LargeCapTradeStrategy();
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

    // Trade stock object
    public void tradeStock(String stock, double bid) {
        System.out.println("Trading " + stock + " stock for bid $" + bid + " on the stock market");
        Iterator stockArr = stocks.iterator();
        while (stockArr.hasNext()) {
            Stock s = (Stock) stockArr.next();
            if (s.getName().equals(stock)) {
                TradeStrategy strategy = tradeStrategy(s);
                double brokerFee = strategy.calculateBrokerFee(bid);
                double adjustedBid = bid - brokerFee;
                s.setBid(adjustedBid);
                System.out.println("Bid successfully placed for: $ " + bid + "\nFinal Amount: $ " +
                        adjustedBid + "\nApplied Broker Fee: $ " + brokerFee + "\n");
                continue;
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

        //Get Stock objects from factory instances
        Stock netflixStock = netflixStockFactoryGoFAndLazySingleton.getStock();
        Stock spotifyStock = spotifyStockFactoryGoFAndEagerSingleton.getStock();
        Stock amazonStock = amazonStockFactoryGoF.getStock();

        //Adding stocks to stock market
        stockMarket.addStock(netflixStock);
        stockMarket.addStock(spotifyStock);
        stockMarket.addStock(amazonStock);

        //Showing all stocks
        stockMarket.showAllStocks();

        //Removing Amazon stock from stock market
        stockMarket.removeStock("AMZN");

        //Showing all stocks again
        stockMarket.showAllStocks();

        //Trading stocks
        stockMarket.tradeStock("NFLX", 75.75);
        stockMarket.tradeStock("SPOT", 75.75);
        stockMarket.showAllStocks();
        stockMarket.tradeStock("NFLX", 113.63);
        stockMarket.tradeStock("SPOT", 113.63);
        stockMarket.showAllStocks();
        stockMarket.tradeStock("NFLX", 170.44);
        stockMarket.tradeStock("SPOT", 170.44);
        stockMarket.showAllStocks();
        stockMarket.tradeStock("NFLX", 255.65);
        stockMarket.tradeStock("SPOT", 255.65);
        stockMarket.showAllStocks();
        stockMarket.tradeStock("NFLX", 383.48);
        stockMarket.tradeStock("SPOT", 383.48);
        stockMarket.showAllStocks();
        stockMarket.tradeStock("NFLX", 575.23);
        stockMarket.tradeStock("SPOT", 575.23);
        stockMarket.showAllStocks();
    }
}
