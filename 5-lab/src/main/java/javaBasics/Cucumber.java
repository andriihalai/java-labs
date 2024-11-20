package javaBasics;

public class Cucumber extends Vegetable {
     public Cucumber(String sort, double weight, String color, double price) {
         super(sort, weight, color, price);
     }

    @Override
    public double getCalories() {
         double caloriesPerGram = 0.15;
         return this.weight * caloriesPerGram;
    }

    @Override
    public String toString() {
        return "cucumber";
    }
}
