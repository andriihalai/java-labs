package javaBasics;

public class Tomato extends Vegetable {
    public Tomato(String sort, double weight, String color, double price) {
        super(sort, weight, color, price);
    }

    @Override
    public double getCalories() {
        double caloriesPerGram = 0.18;
        return this.weight * caloriesPerGram;
    }

    @Override
    public String toString() {
        return "tomato";
    }
}
