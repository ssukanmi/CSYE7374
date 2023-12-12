package edu.neu.csye7374.helper;
import java.util.List;

public class ArrayUtils {
    public static <T extends Enum<T>> String printableMenu(List<T> options) {
        StringBuilder menu = new StringBuilder();
        for (int i = 0; i < options.size(); i++) {
            menu.append(i + 1).append(". ").append(options.get(i).toString()).append("\n");
        }
        return menu.toString();
    }

    public static <T extends Enum<T>> T selectedOption(T[] options, String input) {
        try {
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < options.length) {
                return options[index];
            }
        } catch (NumberFormatException e) {
            // Invalid input
        }
        return null;
    }
}
