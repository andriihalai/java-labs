package javaBasics;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code Text} class represents a collection of {@link Sentence} objects. It processes a given text to break
 * it down into individual sentences. The text is parsed using a regular expression, and each sentence is stored
 * as an instance of the {@code Sentence} class in the {@code sentences} list.
 *
 * <p>The primary functionality of the {@code Text} class is as follows:
 * <ul>
 *   <li>{@link #Text(StringBuilder)}: Constructs a {@code Text} object by splitting the provided text into sentences,
 *       storing each sentence as an instance of {@code Sentence}.</li>
 * </ul>
 *
 * <p>This class is useful for processing a block of text and organizing it into a series of sentences for further analysis.
 *
 * @since 1.0
 */
public class Text {
    public ArrayList<Sentence> sentences;

    /**
     * Constructs a {@code Text} object by parsing the provided text and splitting it into individual sentences.
     * Each sentence is stored as an instance of {@link Sentence} in the {@code sentences} list. The text is divided
     * using a regular expression that captures sentences ending with one of the punctuation marks: '.', '!', or '?'.
     *
     * @param text the {@code StringBuilder} containing the full text to be parsed into sentences
     */
    public Text(StringBuilder text) {
        sentences = new ArrayList<>();
        Pattern sentencePattern = Pattern.compile("[^.!?]+[.!?]");
        Matcher matcher = sentencePattern.matcher(text);

        while (matcher.find()) {
            sentences.add(new Sentence(new StringBuilder(matcher.group().trim())));
        }
    }
}
