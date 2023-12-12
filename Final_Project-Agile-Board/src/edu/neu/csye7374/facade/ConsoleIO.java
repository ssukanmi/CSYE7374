package edu.neu.csye7374.facade;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsoleIO {
    private static final ConsoleIO shared = new ConsoleIO();
    private ConsoleIO() {}

    public static ConsoleIO getInstance() {
        return shared;
    }

    public void writeMessage(String message, OutputType to) {
        if (message.isEmpty()) {
            return;
        }

        switch (to) {
            case STANDARD:
                System.out.println(message);
                break;
            case ERROR:
                System.err.println("Error: " + message);
                break;
        }
    }

    public <T extends String> T acceptInput(String description, Function<String, T> converter, Predicate<T> validator) {
        if (description != null) {
            writeMessage("\n" + description, OutputType.STANDARD);
        }

        T userInput = null;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                writeMessage("Invalid input, please retry...", OutputType.ERROR);
                continue;
            }

            try {
                T convertedInput = converter.apply(input);

                if (validator != null) {
                    boolean isValid = validator.test(convertedInput);

                    if (!isValid) {
                        writeMessage("", OutputType.ERROR);
                        continue;
                    }
                }

                userInput = convertedInput;
                break;
            } catch (NumberFormatException e) {
                writeMessage("Invalid input, please retry...", OutputType.ERROR);
            }
        }

        return userInput;
    }

    public <T extends Enum<T>> T acceptInput(String description, List<T> options) {
        if (description != null) {
            writeMessage("\n" + description, OutputType.STANDARD);
        }

        T option = null;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                writeMessage("Invalid input, please retry...", OutputType.ERROR);
                continue;
            }

            try {
                int integerInput = Integer.parseInt(input);
                T selectedOption = options.get(integerInput - 1);
                option = selectedOption;
                break;
            } catch (Exception e){
                for (T enumOption : options) {
                    if (enumOption.name().equalsIgnoreCase(input)) {
                        option = enumOption;
                        break;
                    }
                }
            }

            if (option != null) {
                break;
            } else {
                writeMessage("Invalid input, please retry...", OutputType.ERROR);
            }
        }

        return option;
    }

    public enum OutputType {
        STANDARD,
        ERROR
    }
}
