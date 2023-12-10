package edu.neu.csye7374;

public class StockMarketObjectAdapter implements CurrencyExchangeAPI {

    private StockMarket stockMarket;

    public StockMarketObjectAdapter(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }

    @Override
    public void tradeStock(String stock, Currency bid) throws Exception {
        Currency usdBid = exchange(bid, CurrencyType.USD);
        stockMarket.tradeStock(stock, usdBid.getValue());
    }

    @Override
    public Currency exchange(Currency amount, CurrencyType currencyType) throws Exception {
        switch (amount.getCurrencyType()) {
            case USD:
                switch (currencyType) {
                    case NGN:
                        return new Currency(currencyType, amount.getValue() * ExchangeConstants.USD_TO_NGN);
                    case CAD:
                        return new Currency(currencyType, amount.getValue() * ExchangeConstants.USD_TO_CAD);
                    case USD:
                        return amount;
                    default:
                        throw new Exception("Invalid currency type");
                }
            case NGN:
                switch (currencyType) {
                    case USD:
                        return new Currency(currencyType, amount.getValue() / ExchangeConstants.USD_TO_NGN);
                    case CAD:
                        return new Currency(currencyType, (amount.getValue() / ExchangeConstants.USD_TO_NGN) * ExchangeConstants.USD_TO_CAD);
                    case NGN:
                        return amount;
                    default:
                        throw new Exception("Invalid currency type");
                }
            case CAD:
                switch (currencyType) {
                    case USD:
                        return new Currency(currencyType, amount.getValue() / ExchangeConstants.USD_TO_CAD);
                    case NGN:
                        return new Currency(currencyType, (amount.getValue() / ExchangeConstants.USD_TO_CAD) * ExchangeConstants.USD_TO_NGN);
                    case CAD:
                        return amount;
                    default:
                        throw new Exception("Invalid currency type");
                }
            default:
                throw new Exception("Invalid currency type");
        }
    }
}
