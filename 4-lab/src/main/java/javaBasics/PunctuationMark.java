package javaBasics;

import java.util.regex.Pattern;

/**
 * The {@code PunctuationMark} class represents a punctuation mark character.
 * This class ensures that only valid punctuation marks ('.', '?', and '!') are allowed.
 * It provides methods to set and check the punctuation mark's type.
 *
 * <p>The primary functionality of the {@code PunctuationMark} class is as follows:
 * <ul>
 *   <li>{@link #PunctuationMark(char)}: Constructs a {@code PunctuationMark} object with the specified character if it is a valid punctuation mark.</li>
 *   <li>{@link #isQuestionMark()}: Returns {@code true} if the punctuation mark is a question mark ('?'), otherwise {@code false}.</li>
 * </ul>
 *
 * <p>This class is used to represent punctuation marks in texts, enabling validation and differentiation between different punctuation types.
 *
 * @since 1.0
 */
public class PunctuationMark {
    public char punctuationMark;

    /**
     * Constructs a new {@code PunctuationMark} with the specified character. The punctuation mark is validated
     * to ensure it is one of the allowed characters: '.', '?', or '!'.
     *
     * @param punctuationMark the character to be represented by this {@code PunctuationMark} object
     * @throws IllegalArgumentException if the character is not a valid punctuation mark (i.e., not '.', '?', or '!')
     */
    public PunctuationMark(char punctuationMark) {
        Pattern pattern = Pattern.compile("[.?!]");
        if (pattern.matcher(String.valueOf(punctuationMark)).matches()) {
            this.punctuationMark = punctuationMark;
        } else {
            throw new IllegalArgumentException("Invalid punctuation mark. Only '.', '?', and '!' are allowed.");
        }
    }

    /**
     * Checks if the punctuation mark is a question mark ('?').
     *
     * @return {@code true} if the punctuation mark is a question mark; {@code false} otherwise
     */
    public boolean isQuestionMark() {
        return punctuationMark == '?';
    }
}
