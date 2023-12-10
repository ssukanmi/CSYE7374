package edu.neu.csye7374;

public interface CurrencyExchangeAPI {
    Currency exchange(Currency amount, CurrencyType currencyType) throws Exception;
    void tradeStock(String stock, Currency bid) throws Exception;
}
