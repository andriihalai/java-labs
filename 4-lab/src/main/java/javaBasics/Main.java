package javaBasics;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(
                "The stars are especially bright tonight. Have you ever you wondered how far away " +
                        "they really are are are? They seem to hold secrets beyond our reach. What if each " +
                        "one has a story of its own?"
        );

        Text text = new Text(sb);

        ArrayList<Word> output = WordsFinder.findWordsOfLength(text, 3);

        for (Word word : output) {
            StringBuilder wordStr = new StringBuilder();
            for (Letter letter : word.getLetters()) {
                wordStr.append(letter.getCharacter());
            }
            System.out.println(wordStr.toString());
        }
    }
}
