package edu.neu.csye7374;

public final class MyCloneableAbstractFactorySingleton extends MyCloneableAbstractFactory {
    private static MyCloneableAbstractFactorySingleton instance;

    private MyCloneableAbstractFactorySingleton() { }

    public static MyCloneableAbstractFactorySingleton getInstance() {
        if (instance == null) {
            instance = new MyCloneableAbstractFactorySingleton();
        }
        return instance;
    }
}
