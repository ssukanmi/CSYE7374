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

    // Add stock object
    public void addStock(Stock stock) {
        System.out.println("Adding stock " + stock.getName() + " to the stock market");
        this.stocks.add(stock);
    }

    // Trade stock object
    public void tradeStock(String stock, double bid) {
        System.out.println("Trading stock " + stock + "for bid $" + bid + " on the stock market");
        Iterator stockArr = stocks.iterator();
        while (stockArr.hasNext()) {
            Stock s = (Stock) stockArr.next();
            if (s.getName().equals(stock)) {
                s.setBid(bid);
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
}
