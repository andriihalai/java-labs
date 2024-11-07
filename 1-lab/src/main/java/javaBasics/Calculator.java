package javaBasics;

/**
 * The {@code Calculator} class provides methods for performing bitwise XOR operations
 * on two-dimensional integer arrays (matrices) and calculating the sum of the largest
 * values in each row of the resultant matrix. It validates the matrices before processing
 * to ensure that they are well-formed and of the same dimensions.
 *
 * <p>This class includes private methods for the core functionalities:
 * <ul>
 *   <li>Performing the XOR operation on matrices.</li>
 *   <li>Calculating the sum of the largest values in each row.</li>
 *   <li>Printing matrices.</li>
 *   <li>Validating matrix dimensions and structure.</li>
 * </ul>
 *
 * <p>The {@link #execute(int[][], int[][])} method is the main public method for
 * executing these operations.
 */
public class Calculator {

    /**
     * Performs element-wise XOR on two matrices and returns the resulting matrix.
     * This method assumes that the matrices have been validated to have the same dimensions.
     *
     * @param A the first matrix to XOR
     * @param B the second matrix to XOR
     * @return the resulting matrix after applying XOR element-wise
     */
    private int[][] XOR(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                C[i][j] = A[i][j] ^ B[i][j];
            }
        }

        return C;
    }

    /**
     * Calculates the sum of the largest values in each row of the given matrix.
     *
     * @param C the matrix to calculate row-wise largest values
     * @return the sum of the largest values in each row of {@code C}
     */
    private int calcRowsBiggestSum(int[][] C) {
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

    /**
     * Validates and processes the input matrices by performing an XOR operation on
     * them, printing the resultant matrix, and calculating the sum of the largest
     * values in each row.
     *
     * <p>Validation checks include:
     * <ul>
     *   <li>Both matrices must be non-null, with non-zero rows and columns.</li>
     *   <li>Each row must be of equal length.</li>
     *   <li>Both matrices must have the same dimensions.</li>
     * </ul>
     *
     * @param A the first matrix to process
     * @param B the second matrix to process
     */
    public void execute(int[][] A, int[][] B) {
        if (!isValidMatrix(A) || !isValidMatrix(B)) {
            System.out.println("Error: One or both matrices are invalid.");
            return;
        }

        if (A.length != B.length || A[0].length != B[0].length) {
            System.out.println("Error: Matrices must have the same dimensions.");
            return;
        }

        int[][] C = this.XOR(A, B);
        this.printMatrix(C);
        int sumOfBiggestValues = this.calcRowsBiggestSum(C);
        System.out.println("Sum of biggest values of each row: " + sumOfBiggestValues);
    }

    /**
     * Prints the given matrix to the console in a readable format.
     *
     * @param matrix the matrix to print
     */
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

    /**
     * Checks if a matrix is valid. A matrix is considered valid if:
     * <ul>
     *   <li>It is non-null.</li>
     *   <li>It has non-zero rows and columns.</li>
     *   <li>All rows have the same number of columns.</li>
     * </ul>
     *
     * @param matrix the matrix to validate
     * @return {@code true} if the matrix is valid; {@code false} otherwise
     */
    private boolean isValidMatrix(int[][] matrix) {
        if (matrix == null) {
            return false;
        }

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int[] row : matrix) {
            if (row == null || row.length != matrix[0].length) {
                return false;
            }
        }

        return true;
    }
}
