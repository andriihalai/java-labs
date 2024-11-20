package javaBasics;

/**
 * Represents a Cucumber, which is a type of vegetable.
 * This class extends the {@link Vegetable} class and provides specific
 * implementations for calculating calories and providing a string representation
 * of the cucumber.
 */
public class Cucumber extends Vegetable {

    /**
     * Constructor to initialize the properties of a cucumber.
     *
     * @param sort  The sort or type of the cucumber (e.g., "English", "Pickling").
     * @param weight The weight of the cucumber in grams.
     * @param color The color of the cucumber (typically "green").
     * @param price The price of the cucumber.
     */
    public Cucumber(String sort, double weight, String color, double price) {
        super(sort, weight, color, price);
    }

    /**
     * Calculates the calorie content of the cucumber based on its weight.
     * The calorie content is estimated using the standard value of 0.15 calories per gram.
     *
     * @return The total calorie content of the cucumber.
     */
    @Override
    public double getCalories() {
        double caloriesPerGram = 0.15;
        return this.weight * caloriesPerGram;
    }

    /**
     * Provides a string representation of the cucumber.
     *
     * @return A string representing the cucumber (e.g., "cucumber").
     */
    @Override
    public String toString() {
        return "cucumber";
    }
}
