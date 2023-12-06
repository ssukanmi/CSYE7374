package edu.neu.csye7374;

import java.util.List;

public class Translator implements TranslatableAPI {

    TranslatorStrategy englishToFrench = new TranslateEnglishToFrench();
    TranslatorStrategy englishToSpanish = new TranslateEnglishToSpanish();
    TranslatorStrategy frenchToEnglish = new TranslateFrenchToEnglish();
    TranslatorStrategy frenchToSpanish = new TranslateFrenchToSpanish();
    TranslatorStrategy spanishToEnglish = new TranslateSpanishToEnglish();
    TranslatorStrategy spanishToFrench = new TranslateSpanishToFrench();

    @Override
    public String translateText(String text, LANGUAGE from, LANGUAGE to) {
        String[] words = sentenceToWordArray(text.toLowerCase());
        String[] translatedWords = new String[words.length];
        for(int i = 0; i < words.length; i++){
            translatedWords[i] = translateWord(words[i].replaceAll("^[!,?]+|[!,?]+$", ""), from, to);
        }
        String translatedText = String.join(" ", translatedWords);
        return translatedText;
    }

    // method to convert a sentence to an array of words
    public String[] sentenceToWordArray(String sentence){
        String[] words = sentence.split(" ");
        return words;
    }

    // method to translate a word from one language to another
    public String translateWord(String word, LANGUAGE from, LANGUAGE to){
        String translatedWord = "";
        if(from == LANGUAGE.ENGLISH){
            if(to == LANGUAGE.SPANISH){
                translatedWord = englishToSpanish.translate(word);
            }
            else if(to == LANGUAGE.FRENCH){

                translatedWord = englishToFrench.translate(word);
            }
        }
        else if(from == LANGUAGE.SPANISH){
            if(to == LANGUAGE.ENGLISH){
                translatedWord = spanishToEnglish.translate(word);
            }
            else if(to == LANGUAGE.FRENCH){
                translatedWord = spanishToFrench.translate(word);
            }
        }
        else if(from == LANGUAGE.FRENCH){
            if(to == LANGUAGE.ENGLISH){
                translatedWord = frenchToEnglish.translate(word);
            }
            else if(to == LANGUAGE.SPANISH){
                translatedWord = frenchToSpanish.translate(word);
            }
        }
        return translatedWord;
    }
}
