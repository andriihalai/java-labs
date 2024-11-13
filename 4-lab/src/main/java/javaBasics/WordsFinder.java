package javaBasics;

import java.util.ArrayList;

public class WordsFinder {

    /**
     * Finds all unique words of a specified length within question sentences in the given text.
     * Only words in question sentences (ending with '?') are considered, and punctuation
     * marks such as '.' and '!' indicate non-question sentences.
     *
     * @param text the input text in which to find words
     * @param targetLength the length of words to search for
     * @return a list of unique {@code Word} objects of the specified length
     */
    public static ArrayList<Word> findWordsOfLength(Text text, int targetLength) {
        ArrayList<Word> resultWords = new ArrayList<>();

        for (Sentence sentence : text.sentences) {
            if (sentence.isQuestion()) {
                for (Object element : sentence.elements) {
                    if (element instanceof Word) {
                        Word word = (Word) element;
                        if (word.getLength() == targetLength && !containsEquivalent(resultWords, word)) {
                            resultWords.add(word);
                        }
                    }
                }
            }
        }

        return resultWords;
    }

    /**
     * Checks if the list of unique words contains an equivalent word to the given word.
     * Words are considered equivalent if they contain the same characters in the same order.
     *
     * @param uniqueWords the list of unique words
     * @param newWord the word to check for equivalence
     * @return {@code true} if an equivalent word is found; {@code false} otherwise
     */
    private static boolean containsEquivalent(ArrayList<Word> uniqueWords, Word newWord) {
        for (Word existingWord : uniqueWords) {
            if (existingWord.equals(newWord)) {
                return true;
            }
        }
        return false;
    }
}
