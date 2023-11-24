package edu.neu.csye7374;

import java.util.List;
import java.util.ArrayList;

public class Command {
    private interface JobCommandAPI {
        public Double execute();
    }

    private interface CalculatorReceiverAPI {
        public Double operation(Double... operands);
    }

    private static class AddReceiver implements CalculatorReceiverAPI {
        @Override
        public Double operation(Double... operands) {
            Double ans = 0.0;
            if (operands.length >= 2) {
                for (Double x: operands) {
                    ans += x;
                }
            }
            return ans;
        }
    }

    private static class SubtractReceiver implements CalculatorReceiverAPI {
        @Override
        public Double operation(Double... operands) {
            Double ans = 0.0;
            if (operands.length >= 2) {
                ans = operands[0] - operands[1];
            }
            return ans;
        }
    }

    private static class MultReceiver implements CalculatorReceiverAPI {
        @Override
        public Double operation(Double... operands) {
            Double ans = 1.0;
            if (operands.length >= 2) {
                for (Double x: operands) {
                    ans *= x;
                }
            }
            return ans;
        }
    }

    private static class DivReceiver implements CalculatorReceiverAPI {
        @Override
        public Double operation(Double... operands) {
            Double ans = 0.0;
            if (operands.length >= 2 && operands[1] != 0.0) {
                for (Double x: operands) {
                    ans = operands[0] / operands[1];
                }
            }
            return ans;
        }
    }

    private static class Job1 implements JobCommandAPI {
        AddReceiver receiver;
        Double a, b;

        public Job1(AddReceiver receiver, Double a, Double b) {
            this.receiver = receiver;
            this.a = a;
            this.b = b;
        }

        @Override
        public Double execute() {
            Double result = receiver.operation(a, b);
            return result;
        }
    }

    private static class Job2 implements JobCommandAPI {
        SubtractReceiver receiver;
        Double a, b;

        public Job2(SubtractReceiver receiver, Double a, Double b) {
            this.receiver = receiver;
            this.a = a;
            this.b = b;
        }

        @Override
        public Double execute() {
            Double result = receiver.operation(a, b);
            return result;
        }
    }

    private static class Job3 implements JobCommandAPI {
        MultReceiver receiver;
        Double a, b;

        public Job3(MultReceiver receiver, Double a, Double b) {
            this.receiver = receiver;
            this.a = a;
            this.b = b;
        }

        @Override
        public Double execute() {
            Double result = receiver.operation(a, b);
            return result;
        }
    }

    private static class Job4 implements JobCommandAPI {
        DivReceiver receiver;
        Double a, b;

        public Job4(DivReceiver receiver, Double a, Double b) {
            this.receiver = receiver;
            this.a = a;
            this.b = b;
        }

        @Override
        public Double execute() {
            Double result = receiver.operation(a, b);
            return result;
        }
    }

    private static class Job5 implements JobCommandAPI {
        AddReceiver receiver;
        Double[] a;

        public Job5(AddReceiver receiver, Double... a) {
            this.receiver = receiver;
            this.a = a;
        }

        @Override
        public Double execute() {
            Double result = receiver.operation(a);
            return result;
        }
    }

    private static class Invoker {
        JobCommandAPI job;

        public Invoker(JobCommandAPI job) {
            this.job = job;
        }

        public void invoke() {
            System.out.println(job.execute());
        }
    }

    public static void demo() {
        AddReceiver add = new AddReceiver();
        SubtractReceiver sub = new SubtractReceiver();
        MultReceiver mul = new MultReceiver();
        DivReceiver div = new DivReceiver();

        List<Invoker> batch = new ArrayList<>();

        batch.add(new Invoker(new Job1(add, 6.0,3.0)));
        batch.add(new Invoker(new Job2(sub, 6.0,3.0)));
        batch.add(new Invoker(new Job3(mul, 6.0,3.0)));
        batch.add(new Invoker(new Job4(div, 6.0,3.0)));
        batch.add(new Invoker(new Job5(add, 1.0 ,2.0 ,3.0 , 4.0)));

        for (int i = 0; i < batch.size(); i++) {
            System.out.println("Result of command " + (i + 1) + " is - ");
            batch.get(i).invoke();
        }
    }
}
