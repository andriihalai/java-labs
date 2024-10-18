package javaBasics;

public class Main {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 2, 8},
                {5, 1, 10},
        };

        int[][] B = {
                {1, 2, 5},
                {4, 3, 9},
                {3, 2, 4},
        };

        Calculator calculator = new Calculator();
        calculator.execute(A, B);
    }
}