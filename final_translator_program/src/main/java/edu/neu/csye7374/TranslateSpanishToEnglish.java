package edu.neu.csye7374;

public class TranslateSpanishToEnglish implements TranslatorStrategy {
    @Override
    public String translate(String word) {
        switch (word.toLowerCase()) {
            case "si":
                return "yes";
            case "nosotros":
                return "we";
            case "hacer":
                return "do";
            case "tener":
                return "have";
            case "no":
                return "no";
            case "pan":
                return "bread";
            case "hoy":
                return "today";
            case "gracias":
                return "thanks";
            case "usted":
                return "you";
            default:
                return word;
        }
    }
}
