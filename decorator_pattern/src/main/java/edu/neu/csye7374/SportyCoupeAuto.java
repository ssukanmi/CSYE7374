package edu.neu.csye7374;

public class SportyCoupeAuto implements AutoAPI {
    public static final String DESCRIPTION = "Sporty Coupe Car";
    public static final double PRICE = 67500;

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION + ", Price: $ " + getPrice();
    }
}
