package edu.neu.csye7374;

public class AntiLockBrakingSystem extends AutoDecoratorAPI {
    public static final String DESCRIPTION = ",\nABS: Anti-lock Braking system";
    public static final double PRICE = 2225;
    private final AutoAPI autoAPI;

    public AntiLockBrakingSystem(AutoAPI autoAPI) {
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


