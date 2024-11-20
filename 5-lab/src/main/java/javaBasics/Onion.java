package javaBasics;

public class Onion extends Vegetable {
    public Onion(String sort, double weight, String color, double price) {
        super(sort, weight, color, price);
    }

    @Override
    public double getCalories() {
        double caloriesPreGram = 0.4;
        return this.weight * caloriesPreGram;
    }

    @Override
    public String toString() {
        return "onion";
    }
}
