package edu.neu.csye7374;

public class BlindSideDetectionMonitor extends AutoDecoratorAPI {
    public static final String DESCRIPTION = ",\nBDM: Blind-side Detection Monitor";
    public static final double PRICE = 920;
    private final AutoAPI autoAPI;

    public BlindSideDetectionMonitor(AutoAPI autoAPI) {
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
