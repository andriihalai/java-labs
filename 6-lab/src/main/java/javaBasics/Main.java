package javaBasics;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vegetable[] vegetables = new Vegetable[] {
                new Cucumber("pickle", 100, "green", 80.5),
                new Cucumber("persian", 130, "green", 89.5),
                new Cucumber("muncher", 144.2, "green", 93.5),
                new Tomato("roma", 127.8, "red", 99.9),
                new Tomato("plum", 100.8, "red", 125.4),
                new Onion("white", 211, "white", 60.2)
        };

        System.out.println("Testing empty constructor...");
        VegetablesSet set = new VegetablesSet();
        System.out.println("Initial size of set: " + set.size());
        System.out.println("Is the set empty? " + set.isEmpty());

        System.out.println("\nAdding all vegetables...");
        set.addAll(Arrays.asList(vegetables));
        System.out.println("Size after adding all: " + set.size());
        System.out.println("Is set empty? " + set.isEmpty());

        System.out.println("\nDoes the set contain 'pickle' cucumber? " + set.contains(vegetables[0]));

        System.out.println("\nRemoving 'pickle' cucumber...");
        boolean removedItem = set.remove(vegetables[0]);
        System.out.println("Removed: " + removedItem);
        System.out.println("Does the set still contain 'pickle' cucumber? " + set.contains(vegetables[0]));

        System.out.println("Size after removal: " + set.size());

        System.out.println("\nAdding duplicate 'persian' cucumber...");
        boolean addedDuplicate = set.add(vegetables[1]);
        System.out.println("Attempted to add duplicate: " + addedDuplicate);

        System.out.println("\nAdding new cucumber 'slicer'...");
        set.add(new Cucumber("slicer", 145.0, "green", 90.0));
        System.out.println("Size after adding 'slicer': " + set.size());

        System.out.println("\nClearing the set...");
        set.clear();
        System.out.println("Size after clearing: " + set.size());
        System.out.println("Is set empty after clearing? " + set.isEmpty());

        System.out.println("\nTesting constructor with one vegetable...");
        VegetablesSet singleSet = new VegetablesSet(new Cucumber("kirby", 120, "green", 85.0));
        System.out.println("Size of singleSet: " + singleSet.size());
        System.out.println("Does singleSet contain 'kirby' cucumber? "
                + singleSet.contains(new Cucumber("kirby", 120, "green", 85.0)));

        System.out.println("\nTesting constructor with collection...");
        VegetablesSet collectionSet = new VegetablesSet(Arrays.asList(vegetables));
        System.out.println("Size of collectionSet: " + collectionSet.size());
        System.out.println("Does collectionSet contain 'roma' tomato? "
                + collectionSet.contains(new Tomato("roma", 127.8, "red", 99.9)));
    }
}
