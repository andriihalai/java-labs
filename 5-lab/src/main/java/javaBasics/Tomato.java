package javaBasics;

/**
 * Represents a Tomato, which is a type of vegetable.
 * This class extends the {@link Vegetable} class and provides specific
 * implementations for calculating calories and providing a string representation
 * of the tomato.
 */
public class Tomato extends Vegetable {

    /**
     * Constructor to initialize the properties of a tomato.
     *
     * @param sort  The sort or type of the tomato (e.g., "Roma", "Cherry", "Beefsteak").
     * @param weight The weight of the tomato in grams.
     * @param color The color of the tomato (e.g., "red", "yellow", "green").
     * @param price The price of the tomato.
     */
    public Tomato(String sort, double weight, String color, double price) {
        super(sort, weight, color, price);
    }

    /**
     * Calculates the calorie content of the tomato based on its weight.
     * The calorie content is estimated using the standard value of 0.18 calories per gram.
     *
     * @return The total calorie content of the tomato.
     */
    @Override
    public double getCalories() {
        double caloriesPerGram = 0.18;
        return this.weight * caloriesPerGram;
    }

    /**
     * Provides a string representation of the tomato.
     *
     * @return A string representing the tomato (e.g., "tomato").
     */
    @Override
    public String toString() {
        return "tomato";
    }
}
