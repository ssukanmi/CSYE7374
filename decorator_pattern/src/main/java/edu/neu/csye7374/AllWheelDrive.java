package edu.neu.csye7374;

public class AllWheelDrive extends AutoDecoratorAPI {
    public static final String DESCRIPTION = ",\nAWD: All Wheel Drive";
    public static final double PRICE = 3200;
    private final AutoAPI autoAPI;

    public AllWheelDrive(AutoAPI autoAPI) {
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

