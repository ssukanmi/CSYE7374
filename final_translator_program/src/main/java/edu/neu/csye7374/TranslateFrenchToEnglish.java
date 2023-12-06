package edu.neu.csye7374;

public class TranslateFrenchToEnglish implements TranslatorStrategy {
    @Override
    public String translate(String word) {
        switch (word.toLowerCase()) {
            case "oui":
                return "yes";
            case "nous":
                return "we";
            case "faire":
                return "do";
            case "avoir":
                return "have";
            case "non":
                return "no";
            case "pain":
                return "bread";
            case "jour":
                return "today";
            case "merci":
                return "thanks";
            case "vous":
                return "you";
            default:
                return word;
        }
    }
}
