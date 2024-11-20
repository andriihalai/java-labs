package javaBasics;

/**
 * Represents an Onion, which is a type of vegetable.
 * This class extends the {@link Vegetable} class and provides specific
 * implementations for calculating calories and providing a string representation
 * of the onion.
 */
public class Onion extends Vegetable {

    /**
     * Constructor to initialize the properties of an onion.
     *
     * @param sort  The sort or type of the onion (e.g., "Yellow", "Red", "Sweet").
     * @param weight The weight of the onion in grams.
     * @param color The color of the onion (e.g., "white", "yellow", "red").
     * @param price The price of the onion.
     */
    public Onion(String sort, double weight, String color, double price) {
        super(sort, weight, color, price);
    }

    /**
     * Calculates the calorie content of the onion based on its weight.
     * The calorie content is estimated using the standard value of 0.4 calories per gram.
     *
     * @return The total calorie content of the onion.
     */
    @Override
    public double getCalories() {
        double caloriesPerGram = 0.4;
        return this.weight * caloriesPerGram;
    }

    /**
     * Provides a string representation of the onion.
     *
     * @return A string representing the onion (e.g., "onion").
     */
    @Override
    public String toString() {
        return "onion";
    }
}
