package javaBasics;

public abstract class Vegetable {
    public String sort;
    public double weight;
    public String color;
    public double price;

    public Vegetable(String sort, double weight, String color, double price) {
        this.sort = sort;
        this.weight = weight;
        this.color = color;
        this.price = price;
    }

    public abstract double getCalories();
}
