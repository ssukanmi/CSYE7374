package edu.neu.csye7374;

import java.util.List;

public class CalculatorAdapter implements AccumulatableAPI {
    private final CalculatableAPI calculator;
    private double sum;

    public CalculatorAdapter(CalculatableAPI calc){
        super();
        this.calculator = calc;
        this.sum = 0;
    }

    @Override
    public double accumulation(List<Double> itemPrices) {
        sum = 0;
        for (double itemPrice : itemPrices) {
            sum = this.calculator.operation(OPERATION.ADD, sum, itemPrice);
        }
        return sum;
    }

    @Override
    public double payment(double payment) {
        return this.calculator.operation(OPERATION.SUB, payment, sum);
    }
}