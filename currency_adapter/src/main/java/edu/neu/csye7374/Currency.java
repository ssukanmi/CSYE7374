package edu.neu.csye7374;

public class Currency {

    private CurrencyType currencyType;
    private double value;

    public Currency(CurrencyType currencyType, double value) {
        this.currencyType = currencyType;
        this.value = value;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public double getValue() {
        return value;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyType=" + currencyType +
                ", value=" + value +
                '}';
    }

}
