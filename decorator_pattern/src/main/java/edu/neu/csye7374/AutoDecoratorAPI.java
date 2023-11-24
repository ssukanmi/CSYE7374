package edu.neu.csye7374;

public abstract class AutoDecoratorAPI implements AutoAPI {
    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
