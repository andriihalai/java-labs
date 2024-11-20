package javaBasics;

/**
 * Abstract class representing a vegetable.
 * This class serves as a blueprint for different types of vegetables
 * with common properties like sort, weight, color, price, and the ability
 * to calculate their calorie content.
 */
public abstract class Vegetable {

    /** The sort or type of the vegetable (e.g., "Tomato", "Cucumber"). */
    public String sort;

    /** The weight of the vegetable, typically in grams. */
    public double weight;

    /** The color of the vegetable (e.g., "green", "red", "yellow"). */
    public String color;

    /** The price of the vegetable, typically in local currency. */
    public double price;

    /**
     * Constructor to initialize a vegetable with its specific properties.
     *
     * @param sort  The sort or type of the vegetable.
     * @param weight The weight of the vegetable.
     * @param color The color of the vegetable.
     * @param price The price of the vegetable.
     */
    public Vegetable(String sort, double weight, String color, double price) {
        this.sort = sort;
        this.weight = weight;
        this.color = color;
        this.price = price;
    }

    /**
     * Abstract method to calculate the calorie content of the vegetable.
     * This method must be implemented by subclasses to return the specific
     * calorie content based on the type of vegetable.
     *
     * @return The calorie content of the vegetable.
     */
    public abstract double getCalories();
}
