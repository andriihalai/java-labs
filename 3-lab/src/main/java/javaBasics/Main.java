package javaBasics;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        SeaBoat[] boats = {
                new SeaBoat("Anna", 2001, 100,
                        60, 200, 50),
                new SeaBoat("Maria", 999, 234,
                        324, 4214, 234),
                new SeaBoat("Victoria", 777, 12345,
                        423, 5467, 2345),
                new SeaBoat("asdf", 342, 15600,
                        4256, 434, 235),
                new SeaBoat("speedy", 3245, 3234,
                        6334, 2356, 3432),
                new SeaBoat("lemon", 4223, 4333,
                        222, 1202, 342)
        };

        Arrays.sort(boats, (boat1, boat2) -> {
            if (boat1.fuelCapacity > boat2.fuelCapacity) {
                return 1;
            } else if (boat1.fuelCapacity < boat2.fuelCapacity) {
                return -1;
            }
            return 0;
        });

        System.out.println("Array sorted by fuelCapacity, ascending order:");
        for (SeaBoat seaBoat: boats) {
            System.out.println(seaBoat.toString());
            System.out.println();
        }

        Arrays.sort(boats, (boat1, boat2) -> {
            if (boat1.weight > boat2.weight) {
                return -1;
            } else if (boat1.weight < boat2.weight) {
                return 1;
            }
            return 0;
        });
        System.out.println("Array sorted by weight, descending order:");
        for (SeaBoat seaBoat: boats) {
            System.out.println(seaBoat.toString());
            System.out.println();
        }

        SeaBoat targetBoat = new SeaBoat("Anna", 2001, 100,
                60, 200, 50);

        for (SeaBoat seaBoat: boats) {
            boolean areEqual = Objects.deepEquals(targetBoat, seaBoat);
            if (areEqual) {
                System.out.println("Match!\n" + seaBoat);
            }
        }
    }
}