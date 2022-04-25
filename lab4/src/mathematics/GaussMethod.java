package mathematics;

import java.util.Arrays;

public class GaussMethod {

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

    private static double[][] copyMatrix(double[][] matrix) {
        double[][] result = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length + 1 >= 0) System.arraycopy(matrix[i], 0, result[i], 0, matrix.length + 1);
        }
        return result;
    }

    private static double[] getNullColumn(int size) {
        double[] column = new double[size];
        Arrays.stream(column)
                .forEach(el -> el = 0);
        return column;
    }

    public static boolean isnNullRow(double[] row) {
        return Arrays.stream(row)
                .allMatch(el -> el == 0);
    }
}