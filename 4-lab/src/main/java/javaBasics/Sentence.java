package javaBasics;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code Sentence} class represents a sentence made up of words and punctuation marks.
 * It processes a given text to extract and store its individual components (words and punctuation marks).
 * The sentence is constructed from a {@link StringBuilder} input, and the words and punctuation marks
 * are stored in an {@code ArrayList}. The class also provides methods to check if the sentence is a question.
 *
 * <p>The primary functionality of the {@code Sentence} class is as follows:
 * <ul>
 *   <li>{@link #Sentence(StringBuilder)}: Constructs a {@code Sentence} object by parsing the provided text
 *       into words and punctuation marks, adding them to the {@code elements} list.</li>
 *   <li>{@link #isQuestion()}: Checks if the sentence ends with a question mark and returns {@code true} if so, otherwise {@code false}.</li>
 * </ul>
 *
 * <p>This class is useful for breaking down a text into its grammatical components and identifying sentence types
 * (such as questions) based on the punctuation marks.
 *
 * @since 1.0
 */
public class Sentence {
    public ArrayList<Object> elements;

    /**
     * Constructs a {@code Sentence} object by parsing the provided text into individual elements.
     * The text is analyzed to identify words and punctuation marks. Words are represented as instances of
     * {@link Word} and punctuation marks are represented as instances of {@link PunctuationMark}.
     *
     * @param text the {@code StringBuilder} containing the text of the sentence to be parsed
     */
    public Sentence(StringBuilder text) {
        elements = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-Za-z0-9]+(?:-[A-Za-z0-9]+)*|[.,?!]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String match = matcher.group();
            if (match.matches("[A-Za-z0-9]+(?:-[A-Za-z0-9]+)*")) {
                elements.add(new Word(new StringBuilder(match)));
            } else if (match.matches("[.,?!]")) {
                elements.add(new PunctuationMark(match.charAt(0)));
            }
        }
    }

    /**
     * Checks if the sentence ends with a question mark ('?').
     *
     * @return {@code true} if the sentence ends with a question mark; {@code false} otherwise
     */
    public boolean isQuestion() {
        if (!elements.isEmpty() && elements.get(elements.size() - 1) instanceof PunctuationMark lastMark) {
            return lastMark.isQuestionMark();
        }
        return false;
    }
}
