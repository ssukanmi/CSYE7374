package edu.neu.csye7374;

public class TranslateEnglishToSpanish implements TranslatorStrategy {
    @Override
    public String translate(String word) {
        switch (word.toLowerCase()) {
            case "yes":
                return "si";
            case "we":
                return "nosotros";
            case "do":
                return "hacer";
            case "have":
                return "tener";
            case "no":
                return "no";
            case "bread":
                return "pan";
            case "today":
                return "hoy";
            case "thanks":
                return "gracias";
            case "you":
                return "usted";
            default:
                return word;
        }
    }
}
