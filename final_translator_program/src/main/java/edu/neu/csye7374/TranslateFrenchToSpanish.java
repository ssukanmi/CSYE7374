package edu.neu.csye7374;

public class TranslateFrenchToSpanish implements TranslatorStrategy {
    @Override
    public String translate(String word) {
        switch (word.toLowerCase()) {
            case "oui":
                return "si";
            case "nous":
                return "nosotros";
            case "faire":
                return "hacer";
            case "avoir":
                return "tener";
            case "no":
                return "no";
            case "pain":
                return "pan";
            case "jour":
                return "dia";
            case "merci":
                return "gracias";
            case "vous":
                return "usted";
            default:
                return word;
        }
    }
}
