package edu.neu.csye7374;

public class BumperToBumperWarrantee extends AutoDecoratorAPI {
    public static final String DESCRIPTION = ",\nBB: Bumper to Bumper warrantee";
    public static final double PRICE = 755;
    private final AutoAPI autoAPI;

    public BumperToBumperWarrantee(AutoAPI autoAPI) {
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

