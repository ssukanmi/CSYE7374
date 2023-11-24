package edu.neu.csye7374;

public final class AutoOrderingSystem {
    public void simulateOrdering() {
        System.out.println("...Simulating Auto Ordering System ...\n");

        AutoAPI sportyCoupe = new SportyCoupeAuto();
        sportyCoupe = new AirConditioning(sportyCoupe);
        sportyCoupe = new AllWheelDrive(sportyCoupe);
        sportyCoupe = new AntiLockBrakingSystem(sportyCoupe);
        sportyCoupe = new BumperToBumperWarrantee(sportyCoupe);
        sportyCoupe = new BlindSideDetectionMonitor(sportyCoupe);
        System.out.println(sportyCoupe.getDescription() + "\nFinal Price: $ " + sportyCoupe.getPrice());
    }

    public static void demo() {
        AutoOrderingSystem autoOrderingSystem = new AutoOrderingSystem();
        autoOrderingSystem.simulateOrdering();
    }
}
