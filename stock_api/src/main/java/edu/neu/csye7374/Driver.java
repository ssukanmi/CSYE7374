package edu.neu.csye7374;

/**
 * @author SaiAkhil
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("============Main Execution Start===================\n\n");

        //Add your code in between these two print statements

        StockMarket stockMarket = StockMarket.getInstance();

        stockMarket.addStock(new NetflixStock());
        stockMarket.addStock(new SpotifyStock());
        stockMarket.addStock(new AmazonStock());
        stockMarket.showAllStocks();
        stockMarket.removeStock("AMZN");
        stockMarket.showAllStocks();
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

        System.out.println("\n\n============Main Execution End===================");
    }
}
