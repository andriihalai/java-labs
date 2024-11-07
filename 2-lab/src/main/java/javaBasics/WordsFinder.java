package javaBasics;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * The {@code WordsFinder} class provides utility methods for finding unique words of a specific
 * length within question sentences in a text. The words are extracted in reverse order
 * from the input and then normalized (duplicates removed) before being returned.
 *
 * <p>The primary method in this class is:
 * <ul>
 *   <li>{@link #findWordsOfLength(StringBuilder, int)}: Finds words of a specified length within
 *   question sentences in the given text.</li>
 * </ul>
 *
 * <p>The class includes private helper methods to:
 * <ul>
 *   <li>Remove duplicate words.</li>
 *   <li>Check if a list contains an equivalent word.</li>
 *   <li>Compare two words for equality.</li>
 * </ul>
 */
public class WordsFinder {

    /**
     * Finds all unique words of a specified length within question sentences in the given text.
     * Words are extracted from question sentences, starting from the end of the input.
     * Only words in question sentences (ending with '?') are considered, and punctuation
     * marks such as '.' and '!' indicate non-question sentences.
     *
     * @param sb the input text in which to find words
     * @param targetLength the length of words to search for
     * @return a list of unique {@code StringBuilder} words of the specified length
     */
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

    /**
     * Removes duplicate words from the list of words. Each word is compared to
     * every other word, and only unique words are retained.
     *
     * @param words the list of words from which to remove duplicates
     * @return a list of unique words
     */
    private static ArrayList<StringBuilder> removeDuplicates(ArrayList<StringBuilder> words) {
        ArrayList<StringBuilder> uniqueWords = new ArrayList<>();

        for (StringBuilder word : words) {
            if (!containsEquivalent(uniqueWords, word)) {
                uniqueWords.add(word);
            }
        }

        return uniqueWords;
    }

    /**
     * Checks if the list of unique words contains an equivalent word to the given word.
     * Words are considered equivalent if they contain the same characters in the same order.
     *
     * @param uniqueWords the list of unique words
     * @param newWord the word to check for equivalence
     * @return {@code true} if an equivalent word is found; {@code false} otherwise
     */
    private static boolean containsEquivalent(ArrayList<StringBuilder> uniqueWords, StringBuilder newWord) {
        for (StringBuilder existingWord : uniqueWords) {
            if (areEqual(existingWord, newWord)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compares two {@code StringBuilder} objects for equality. They are considered
     * equal if they have the same length and identical character sequences.
     *
     * @param sb1 the first {@code StringBuilder} to compare
     * @param sb2 the second {@code StringBuilder} to compare
     * @return {@code true} if both {@code StringBuilder} objects are equal; {@code false} otherwise
     */
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
