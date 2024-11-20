package javaBasics;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Represents a Salad containing various vegetables.
 * This class allows adding vegetables, calculating the total calorie content,
 * finding vegetables within a specified calorie range, and sorting the vegetables.
 */
public class Salad {

    /** The list of vegetables included in the salad. */
    public ArrayList<Vegetable> ingredients;

    /**
     * Constructor to initialize the Salad with a list of vegetables.
     *
     * @param vegetables A list of vegetables to add to the salad.
     */
    public Salad(ArrayList<Vegetable> vegetables) {
        this.ingredients = new ArrayList<>(vegetables);
    }

    /**
     * Calculates the total calorie content of the salad based on the individual
     * calories of all the vegetables in the ingredients list.
     *
     * @return The total calories of the salad.
     */
    public double calculateCalories() {
        double caloriesTotal = 0;
        for (Vegetable vegetable: this.ingredients) {
            caloriesTotal += vegetable.getCalories();
        }
        return caloriesTotal;
    }

    /**
     * Finds and returns a list of vegetables in the salad that have a calorie
     * content within the specified range.
     *
     * @param minCalories The minimum calorie content for the vegetables to be included.
     * @param maxCalories The maximum calorie content for the vegetables to be included.
     * @return A list of vegetables whose calorie content is within the specified range.
     */
    public ArrayList<Vegetable> findVegetablesByCalorieRange(double minCalories, double maxCalories) {
        ArrayList<Vegetable> vegetables = new ArrayList<>();
        for(Vegetable vegetable: this.ingredients) {
            double calories = vegetable.getCalories();
            if (calories >= minCalories && calories <= maxCalories) {
                vegetables.add(vegetable);
            }
        }
        return vegetables;
    }

    /**
     * Sorts the vegetables in the salad based on a provided comparator.
     *
     * @param comparator A comparator that defines the sorting order for the vegetables.
     */
    public void sortVegetables(Comparator<Vegetable> comparator) {
        this.ingredients.sort(comparator);
    }
}
