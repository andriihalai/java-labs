package javaBasics;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code Word} class represents a word composed of a sequence of {@link Letter} objects. Each word is created
 * by parsing a {@code StringBuilder} containing alphanumeric characters (letters and digits), and each character
 * is stored as an individual {@code Letter}.
 *
 * <p>The {@code Word} class provides methods to:
 * <ul>
 *   <li>Access the individual {@code Letter} objects that make up the word via {@link #getLetters()}.</li>
 *   <li>Retrieve the length of the word by counting the number of {@code Letter} objects in it with {@link #getLength()}.</li>
 *   <li>Compare the equality of two {@code Word} objects using the {@link #equals(Object)} method.</li>
 * </ul>
 *
 * <p>This class is useful for representing words as sequences of letters, enabling word-level manipulations
 * and comparisons.
 *
 * @since 1.0
 */
public class Word {
    public ArrayList<Letter> letters;

    /**
     * Constructs a {@code Word} object by parsing the given text and creating individual {@code Letter} objects
     * for each alphanumeric character (letters and digits). The characters are extracted using a regular expression
     * that matches alphanumeric characters and stored as {@code Letter} objects in the {@code letters} list.
     *
     * @param text the {@code StringBuilder} containing the word to be parsed into letters
     */
    public Word(StringBuilder text) {
        letters = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Za-z0-9]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            char letter = matcher.group().charAt(0);
            letters.add(new Letter(letter));
        }
    }

    /**
     * Returns the list of {@code Letter} objects that make up this word.
     *
     * @return a list of {@code Letter} objects representing the word
     */
    public ArrayList<Letter> getLetters() {
        return this.letters;
    }

    /**
     * Returns the length of the word, which is the number of {@code Letter} objects it contains.
     *
     * @return the length of the word (number of letters)
     */
    public int getLength() {
        return letters.size();
    }

    /**
     * Compares this {@code Word} object with another object for equality. Two {@code Word} objects are considered
     * equal if they have the same length and the same sequence of {@code Letter} objects.
     *
     * @param obj the object to compare this {@code Word} to
     * @return {@code true} if the words are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word word = (Word) obj;
        if (word.getLength() != this.getLength()) return false;

        for (int i = 0; i < letters.size(); i++) {
            if (letters.get(i).getCharacter() != word.letters.get(i).getCharacter()) {
                return false;
            }
        }
        return true;
    }
}
