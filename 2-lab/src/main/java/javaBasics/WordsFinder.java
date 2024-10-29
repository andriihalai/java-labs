package javaBasics;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class WordsFinder {
    public static ArrayList<StringBuilder> findWordsOfLength(StringBuilder sb, int targetLength) {
        boolean isQuestionSentence = false;
        StringBuilder currentWord = new StringBuilder();
        String endOfTheSentence = "[!.]";
        ArrayList<StringBuilder> words = new ArrayList<>();

        for (int i = sb.length() - 1; i >= 0; i--) {
            char currentCharacter = sb.charAt(i);
            if (currentCharacter == '?') {
                isQuestionSentence = true;
                continue;
            } else if (Pattern.matches(endOfTheSentence, String.valueOf(currentCharacter))) {
                isQuestionSentence = false;
                continue;
            }

            if (isQuestionSentence) {
                if (currentCharacter == ' ') {
                    if (currentWord.length() == targetLength) {
                        StringBuilder data = new StringBuilder(currentWord.reverse());
                        words.add(data);
                    }
                    currentWord.setLength(0);
                } else {
                    currentWord.append(currentCharacter);
                }
            }
        }

        return removeDuplicates(words);
    }

    private static ArrayList<StringBuilder> removeDuplicates(ArrayList<StringBuilder> words) {
        ArrayList<StringBuilder> uniqueWords = new ArrayList<>();

        for (StringBuilder word : words) {
            if (!containsEquivalent(uniqueWords, word)) {
                uniqueWords.add(word);
            }
        }

        return uniqueWords;
    }

    private static boolean containsEquivalent(ArrayList<StringBuilder> uniqueWords, StringBuilder newWord) {
        for (StringBuilder existingWord : uniqueWords) {
            if (areEqual(existingWord, newWord)) {
                return true;
            }
        }
        return false;
    }

    private static boolean areEqual(StringBuilder sb1, StringBuilder sb2) {
        if (sb1.length() != sb2.length()) {
            return false;
        }
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
