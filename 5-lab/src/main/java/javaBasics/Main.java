package javaBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vegetable> vegetables = new ArrayList<>(Arrays.asList(
            new Cucumber("pickle", 100, "green", 80.5),
            new Cucumber("persian", 130, "green", 89.5),
            new Cucumber("muncher", 144.2, "green", 93.5),
            new Tomato("roma", 127.8, "red", 99.9),
            new Tomato("plum", 100.8, "red", 125.4),
            new Onion("white", 211, "white", 60.2)
        ));

        Salad salad = new Salad(vegetables);
        double calories = salad.calculateCalories();
        System.out.println("Calories of the salad: " + calories);

        salad.sortVegetables(Comparator.comparingDouble(Vegetable::getCalories));
        System.out.println("Sorted by calories vegetables:");
        for(Vegetable vegetable: salad.ingredients) {
            System.out.println(vegetable.toString() + " " + vegetable.getCalories());
        }

        ArrayList<Vegetable> targetVegetables = salad.findVegetablesByCalorieRange(20, 22);
        System.out.println("Vegetables of the target calories range:");
        for(Vegetable vegetable: targetVegetables) {
            System.out.println(vegetable.toString() + " " + vegetable.getCalories());
        }
    }
}