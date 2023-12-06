package edu.neu.csye7374;

public class TranslatorDemo {
    public static void demo() {
        TranslatableAPI translator = new Translator();

        String text2 = "Yes";
        String translatedText2 = translator.translateText(text2, LANGUAGE.ENGLISH, LANGUAGE.FRENCH);
        String translatedText2Back = translator.translateText(translatedText2, LANGUAGE.FRENCH, LANGUAGE.ENGLISH);
        System.out.println(text2 + " from English to French: " + translatedText2);
        System.out.println(translatedText2 + " from French to English: " + translatedText2Back + "\n");

        String text3 = "Yes?";
        String translatedText3 = translator.translateText(text3, LANGUAGE.ENGLISH, LANGUAGE.SPANISH);
        String translatedText3Back = translator.translateText(translatedText3, LANGUAGE.SPANISH, LANGUAGE.ENGLISH);
        System.out.println(text3 + " from English to Spanish: " + translatedText3);
        System.out.println(translatedText3 + " from Spanish to English: " + translatedText3Back + "\n");

        String text4 = "Yes!";
        String translatedText4 = translator.translateText(text4, LANGUAGE.ENGLISH, LANGUAGE.FRENCH);
        String translatedText4Back = translator.translateText(translatedText4, LANGUAGE.FRENCH, LANGUAGE.ENGLISH);
        System.out.println(text4 + " from English to French: " + translatedText4);
        System.out.println(translatedText4 + " from French to English: " + translatedText4Back + "\n");


        String text5 = "Do you have bread?";
        String translatedText5 = translator.translateText(text5, LANGUAGE.ENGLISH, LANGUAGE.SPANISH);
        String translatedText5Back = translator.translateText(translatedText5, LANGUAGE.SPANISH, LANGUAGE.ENGLISH);
        System.out.println(text5 + " from English to Spanish: " + translatedText5);
        System.out.println(translatedText5 + " from Spanish to English: " + translatedText5Back + "\n");

        String text6 = "Yes, we DO have no bread today!";
        String translatedText6 = translator.translateText(text6, LANGUAGE.ENGLISH, LANGUAGE.FRENCH);
        String translatedText6Back = translator.translateText(translatedText6, LANGUAGE.FRENCH, LANGUAGE.ENGLISH);
        System.out.println(text6 + " from English to French: " + translatedText6);
        System.out.println(translatedText6 + " from French to English: " + translatedText6Back + "\n");

        String text7 = "Thanks!";
        String translatedText7 = translator.translateText(text7, LANGUAGE.ENGLISH, LANGUAGE.SPANISH);
        String translatedText7Back = translator.translateText(translatedText7, LANGUAGE.SPANISH, LANGUAGE.ENGLISH);
        System.out.println(text7 + " from English to Spanish: " + translatedText7);
        System.out.println(translatedText7 + " from Spanish to English: " + translatedText7Back + "\n");

    }
}
