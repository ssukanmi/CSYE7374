package edu.neu.csye7374;

public class TranslateSpanishToFrench implements TranslatorStrategy {
    @Override
    public String translate(String word) {
        switch (word.toLowerCase()) {
            case "si":
                return "oui";
            case "nosotros":
                return "nous";
            case "hacer":
                return "faire";
            case "tener":
                return "avoir";
            case "no":
                return "no";
            case "pan":
                return "pain";
            case "hoy":
                return "jour";
            case "gracias":
                return "merci";
            case "usted":
                return "vous";
            default:
                return word;
        }
    }
}
