package javaBasics;

import java.util.regex.Pattern;

/**
 * The {@code Letter} class represents a single alphanumeric character.
 * This class ensures that only valid alphanumeric characters (A-Z, a-z, 0-9) are allowed.
 * It provides methods to set and get the character value, ensuring the integrity of the letter.
 *
 * <p>The main functionality of the {@code Letter} class is as follows:
 * <ul>
 *   <li>{@link #setLetter(char)}: Sets the letter if it is a valid alphanumeric character; otherwise, throws an {@link IllegalArgumentException}.</li>
 *   <li>{@link #getCharacter()}: Returns the character stored in the {@code Letter} object.</li>
 * </ul>
 *
 * <p>This class is typically used as part of larger data structures, such as words, where individual characters need to be validated and represented.
 *
 * @since 1.0
 */
public class Letter {
    private char letter;

    /**
     * Constructs a new {@code Letter} with the specified character. The letter is validated
     * to ensure it is alphanumeric (A-Z, a-z, 0-9).
     *
     * @param letter the character to be represented by this {@code Letter} object
     * @throws IllegalArgumentException if the character is not alphanumeric
     */
    public Letter(char letter) {
        this.setLetter(letter);
    }

    /**
     * Sets the letter of this {@code Letter} object. The letter must be an alphanumeric character.
     *
     * @param letter the character to set
     * @throws IllegalArgumentException if the character is not alphanumeric
     */
    public void setLetter(char letter) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9]");
        if (pattern.matcher(String.valueOf(letter)).matches()) {
            this.letter = letter;
        } else {
            throw new IllegalArgumentException("Invalid character. Only alphanumeric characters are allowed.");
        }
    }

    /**
     * Returns the character represented by this {@code Letter} object.
     *
     * @return the character stored in this {@code Letter} object
     */
    public Object getCharacter() {
        return letter;
    }
}
