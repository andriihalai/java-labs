package javaBasics;

import java.util.Objects;

/**
 * The SeaBoat class represents a boat and stores basic information about it.
 * This information includes the boat's name, the year it was made,
 * how much fuel it can hold, its top speed, its weight, and how many passengers it can carry.
 */
public class SeaBoat {

    /** The name of the boat. */
    public String name;

    /** The year the boat was manufactured. */
    public int yearOfManufacture;

    /** The maximum amount of fuel the boat can hold, in liters. */
    public double fuelCapacity;

    /** The boat's maximum speed in knots. */
    public double maxSpeed;

    /** The weight of the boat in tons. */
    public double weight;

    /** The maximum number of passengers the boat can carry. */
    public int maxPassengerCount;

    /**
     * Creates a new SeaBoat object with the given information.
     *
     * @param name               the boat's name
     * @param yearOfManufacture  the year the boat was made
     * @param fuelCapacity       the maximum amount of fuel the boat can hold (in liters)
     * @param maxSpeed           the boat's top speed (in knots)
     * @param weight             the boat's weight (in tons)
     * @param maxPassengerCount  the maximum number of passengers the boat can carry
     */
    public SeaBoat(String name, int yearOfManufacture, double fuelCapacity,
                   double maxSpeed, double weight, int maxPassengerCount) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.fuelCapacity = fuelCapacity;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.maxPassengerCount = maxPassengerCount;
    }

    /**
     * Returns a string with all the details about the boat.
     *
     * @return a string with the boat's name, manufacturing year, fuel capacity, max speed, weight, and passenger count
     */
    @Override
    public String toString() {
        return "name: " + this.name + "\nyearOfManufacture: " + this.yearOfManufacture +
                "\nfuelCapacity: " + this.fuelCapacity + "\nmaxSpeed: " + this.maxSpeed +
                "\nweight: " + this.weight + "\nmaxPassengerCount: " + this.maxPassengerCount;
    }

    /**
     * Checks if this boat is equal to another object.
     * Two SeaBoat objects are considered equal if all their properties are the same.
     *
     * @param obj the object to compare with this boat
     * @return true if the objects are equal; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        SeaBoat other = (SeaBoat) obj;
        return yearOfManufacture == other.yearOfManufacture &&
                Double.compare(fuelCapacity, other.fuelCapacity) == 0 &&
                Double.compare(maxSpeed, other.maxSpeed) == 0 &&
                Double.compare(weight, other.weight) == 0 &&
                maxPassengerCount == other.maxPassengerCount &&
                Objects.equals(name, other.name);
    }

    /**
     * Returns a hash code for this boat.
     *
     * @return an integer hash code based on the boat's properties
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfManufacture, fuelCapacity, maxSpeed, weight, maxPassengerCount);
    }
}
