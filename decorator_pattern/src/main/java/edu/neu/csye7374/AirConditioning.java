package edu.neu.csye7374;

public class AirConditioning extends AutoDecoratorAPI {
    public static final String DESCRIPTION = ",\nAC: Air Conditioning";
    public static final double PRICE = 800;
    private final AutoAPI autoAPI;

    public AirConditioning(AutoAPI autoAPI) {
        this.autoAPI = autoAPI;
    }

    @Override
    public double getPrice() {
        return autoAPI.getPrice() + PRICE;
    }

    @Override
    public String getDescription() {
        return autoAPI.getDescription() + DESCRIPTION + ", Price: $ " + PRICE;
    }
}
