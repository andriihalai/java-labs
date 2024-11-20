package javaBasics;

import java.util.ArrayList;
import java.util.Comparator;

public class Salad {
    public ArrayList<Vegetable> ingredients;

    public Salad(ArrayList<Vegetable> vegetables) {
        this.ingredients = new ArrayList<>(vegetables);
    }

    public double calculateCalories() {
        double caloriesTotal = 0;
        for (Vegetable vegetable: this.ingredients) {
            caloriesTotal += vegetable.getCalories();
        }
        return caloriesTotal;
    }

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

    public void sortVegetables(Comparator<Vegetable> comparator) {
        this.ingredients.sort(comparator);
    }
}
