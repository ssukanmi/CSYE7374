package edu.neu.csye7374;

import java.util.Arrays;
import java.util.List;

public class CalculatorDemo {

    public static void demo() {

        System.out.println("============ Demonstrating Adapter Structural Object Design Pattern ===================\n\n");
        CalculatableAPI calculator = new Calculator();
        CalculatorAdapter adapter = new CalculatorAdapter(calculator);
        List<Double> priceList = Arrays.asList(10.0, 5.0, 16.5, 14.25, 5.60);
        System.out.println("Price List: ");
        for (int i = 0; i < priceList.stream().count(); i++) {
            System.out.print(priceList.get(i));
            if (i < priceList.stream().count() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\n\nTotal Price: $" + adapter.accumulation(priceList));
        System.out.println("\nPaid: $" + "100" + " and received change: $"+ adapter.payment(100));

        System.out.println("\n============ Demonstrating Adapter Structural Class Design Pattern ===================\n\n");
        CalculatorClassAdapter classAdapter = new CalculatorClassAdapter();
        List<Double> priceListB = Arrays.asList(12.0, 15.0, 36.5, 4.25, 5.50);
        System.out.println("Price List: ");
        for (int i = 0; i < priceListB.stream().count(); i++) {
            System.out.print(priceListB.get(i));
            if (i < priceListB.stream().count() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\n\nTotal Price: $" + classAdapter.accumulation(priceListB));
        System.out.println("\nPaid: $" + "100" + " and received change: $"+ classAdapter.payment(100));
    }
}
