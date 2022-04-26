package mathematics;

import java.util.Arrays;

/**
 * Class for realization of Gauss method for
 * solving system of equations
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public class GaussMethod {

    /**
     * Gauss method implementation
     * @param matrix is matrix of coefficients
     * @param results is vector-column of right-side values for system of equations
     * @return matrix of calculated results
     */
    public static double[][] gaussMethod(double[][] matrix, double[] results) {
        double[][] fullMatrix = createFullMatrix(matrix, results);
        double[][] copyMatrix = copyMatrix(fullMatrix);
        for (int k = 0; k < copyMatrix.length - 1; k++) {
            if (copyMatrix[0][0] == 0) continue;
            for (int i = k + 1; i < copyMatrix.length; i++) {
                if (copyMatrix[i][k] == 0) continue;
                double specialEl = copyMatrix[i][k];
                for (int j = 0; j < copyMatrix.length + 1; j++) {
                    copyMatrix[i][j] -= (double) Math.round(copyMatrix[k][j] * (specialEl / copyMatrix[k][k]) * 1000) / 1000;
                }
            }
        }
        return copyMatrix;
    }

    /**
     * Method for receiving column of unknown variables
     * @param matrix is matrix of coefficients
     * @param results is vector-column of right-side values for system of equations
     * @return necessary column
     */
    public static double[] getUnknownColumn(double[][] matrix, double[] results) {
        double[][] triangle = gaussMethod(matrix, results);
        double[] unknowns = getNullColumn(results.length);
        for (int i = triangle.length - 1; i >= 0; i--) {
            double elementsSum = 0;
            double b = triangle[i][triangle.length];
            if (!isnNullRow(triangle[i]) && triangle[i][i] != 0) {
                for (int j = 0; j < triangle.length; j++) {
                    if (j != i) elementsSum += unknowns[j] * triangle[i][j];
                }
                unknowns[i] = (b - elementsSum) / triangle[i][i];
            }
        }
        return unknowns;

    }

    /**
     * Method for crating full matrix (coefficients + column of answers)
     * @param matrix is matrix of coefficients
     * @param result is vector-column of right-side values for system of equations
     * @return full matrix for system of equations
     */
    private static double[][] createFullMatrix(double[][] matrix, double[] result) {
        double[][] fullMatrix = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, fullMatrix[i], 0, matrix.length);
        }
        for (int i = 0; i < matrix.length; i++) {
            fullMatrix[i][matrix.length] = result[i];
        }
        return fullMatrix;
    }

    /**
     * Method for matrix coping
     * @param matrix is matrix for coping
     * @return copy of given matrix
     */
    private static double[][] copyMatrix(double[][] matrix) {
        double[][] result = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length + 1 >= 0) System.arraycopy(matrix[i], 0, result[i], 0, matrix.length + 1);
        }
        return result;
    }

    /**
     * Method for getting zero-column
     * @param size is necessary size of zero-column
     * @return zero column with necessary size
     */
    private static double[] getNullColumn(int size) {
        double[] column = new double[size];
        Arrays.stream(column)
                .forEach(el -> el = 0);
        return column;
    }

    /**
     * Method for checking if given row is zero-row
     * @param row is given row
     * @return result of row checking to 0 in each item
     */
    public static boolean isnNullRow(double[] row) {
        return Arrays.stream(row)
                .allMatch(el -> el == 0);
    }

}