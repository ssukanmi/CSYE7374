package edu.neu.csye7374;

public class TranslateEnglishToFrench implements TranslatorStrategy {
    @Override
    public String translate(String word) {
        switch (word.toLowerCase()) {
            case "yes":
                return "oui";
            case "we":
                return "nous";
            case "do":
                return "faire";
            case "have":
                return "avoir";
            case "no":
                return "no";
            case "bread":
                return "pain";
            case "today":
                return "jour";
            case "thanks":
                return "merci";
            case "you":
                return "vous";
            default:
                return word;
        }
    }
}
