package javaBasics;

public class Calculator {
    public int[][] XOR(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                C[i][j] = A[i][j] ^ B[i][j];
            }
        }

        return C;
    }

    public int calcRowsBiggestSum(int[][] C) {
        int sum = 0;
        for (int[] row : C) {
            int biggestInt = row[0];
            for (int i = 1; i < row.length; i++) {
                biggestInt = Math.max(row[i], biggestInt);
            }
            sum += biggestInt;
        }
        return sum;
    }

    public void execute(int[][] A, int[][] B) {
        int[][] C = this.XOR(A, B);
        this.printMatrix(C);
        int sumOfBiggestValues = this.calcRowsBiggestSum(C);
        System.out.println("Sum of biggest values of each row: " + sumOfBiggestValues);
    }

    private void printMatrix(int[][] matrix) {
        System.out.println("[");
        for (int[] row : matrix) {
            System.out.print(" [");
            for (int j : row) {
                System.out.print(" " + j);
            }
            System.out.println(" ]");
        }
        System.out.println("]");
    }
}
