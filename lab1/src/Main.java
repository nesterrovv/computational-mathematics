import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Gaussian linear equation solver launched!");
            System.out.println("Type ctrl + D (or cmd + D for macOS) to exit.");
            int mood = chooseMood();
            double[][] matrix;
            if (mood == 1) {
                matrix = receiveMatrixFromInput();
            } else if (mood == 2) {
                matrix = generateRandomMatrix();
            } else if (mood == 3) {
                matrix = receiveMatrixFromFile();
            } else throw new Exception();
            System.out.println("Your augmented matrix:");
            printMatrix(matrix);
            System.out.println();
            double[] answers = gaussSolution(matrix);
            System.out.println();
            System.out.println("Values of variables for your system of linear equations:");
            printVector(answers);
            /*
            TODO:
            1. fix matrix - add vector with b1...bn - DONE
            2. choose method of matrix input for user
            3. running logic
            4. first and second step of gauss method -
            5. check if solution is exists
            6. check if equations number == number of unknown variables
             */
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println("\u001B[32m" + "Finishing a program..." + "\u001B[0m");
            System.exit(-1);
        } catch (Exception exception) {
            System.err.println("Fatal error. Try again.");
            System.exit(1);
        }
    }

    public static int receiveDimension(String value) {
        while (true) {
            System.out.print("Enter " + value + ": ");
            try {
                Scanner scanner = new Scanner(System.in);
                int number = scanner.nextInt();
                if (number <= 0 || number > 20) {
                    throw new InputMismatchException();
                }
                return number;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("\u001B[31m" + "Value must be a number from [1;20]!" + "\u001B[0m");
            }
        }
    }

    public static int chooseMood() {
            while (true) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Choose type of data entering. Print only a number:");
                    System.out.println("1. Enter data manually;");
                    System.out.println("2. Generate random data;");
                    System.out.println("3. Read data from file;");
                    int mood = scanner.nextInt();
                    if (mood != 1 && mood != 2 && mood != 3) {
                        throw new InputMismatchException();
                    }
                    return mood;
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("\u001B[31m" + "Value must be a number 1, 2 or 3! Try again." + "\u001B[0m");
                }
            }

    }

    public static double receiveCoefficient(String value) {
        while (true) {
            System.out.print("Enter " + value + ": ");
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextDouble();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("\u001B[31m" + "Value must be a number (for example: 1 or 123.45)!" + "\u001B[0m");
            }
        }
    }

    public static void showMatrixExample() {
        System.out.println("Your system of linear equations looks like this:");
        System.out.println("a(11) * x(1) + a(12) * x(2) + ... + a(1n) * x(n) = b(1)");
        System.out.println("a(21) * x(1) + a(22) * x(2) + ... + a(2n) * x(n) = b(2)");
        System.out.println(".....   ....   .....   ....   ...   .....   ....   ....");
        System.out.println("a(31) * x(1) + a(32) * x(2) + ... + a(3n) * x(n) = b(n)");
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] doubles : matrix) { //Cycles through rows
            for (double aDouble : doubles) {//Cycles through columns
                System.out.printf("%-12.4f", new Double(aDouble)); //change the %5d to however much space you want
            }
            System.out.println(); //Makes a new row
        }
    }

    public static void printVector(double[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println("x(" + (i + 1) + ") = " + vector[i]);
        }
    }

    public static double[][] receiveMatrixFromInput() {
        Scanner scanner = new Scanner(System.in);
        int bIndex = 1;
        showMatrixExample();
        int dimension = receiveDimension("number of unknown variables");
        double[][] matrix = new double[dimension][dimension + 1];
        System.out.println("You need to enter a(i j) values now. Let's try!");
        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension + 1; j++) {
                if (j == dimension + 1) {
                    System.out.println("Enter an coefficient b(" + bIndex + ")");
                    double coefficient = receiveCoefficient("value");
                    matrix[i - 1][j - 1] = coefficient;
                    bIndex += 1;
                } else {
                    System.out.println("Enter an coefficient a(" + i + ")(" + j + ")");
                    double coefficient = receiveCoefficient("value");
                    matrix[i - 1][j - 1] = coefficient;
                }
            }
        }
        System.out.println();
        return matrix;
    }

    public static double[][] generateRandomMatrix() {
        Scanner scanner = new Scanner(System.in);
        int bIndex = 1;
        showMatrixExample();
        int dimension = receiveDimension("number of unknown variables");
        double[][] matrix = new double[dimension][dimension + 1];
        System.out.println("Random matrix generating...");
        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension + 1; j++) {
                if (j == dimension + 1) {
                    double coefficient = Math.random() * 100;
                    matrix[i - 1][j - 1] = coefficient;
                    bIndex += 1;
                } else {
                    double coefficient = Math.random() * 100;
                    matrix[i - 1][j - 1] = coefficient;
                }
            }
        }
        System.out.println();
        return matrix;
    }

    public static double[][] receiveMatrixFromFile() {
        int dimension = receiveDimension("number of unknown variables");
        while (true) {
            try {
                Scanner pathScanner = new Scanner(System.in);
                System.out.print("Enter full path to the file: ");
                String path = pathScanner.nextLine();
                File file = new File(path);
                if (!(file.exists() && file.isFile())) throw new FileNotFoundException();
                if (!file.canRead()) throw new PermissionDeniedException();
                Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(file)));
                double[][] matrix = new double[dimension][dimension];
                while (fileScanner.hasNextLine()) {
                    for (int i = 0; i < matrix.length; i++) {
                        String[] line = fileScanner.nextLine().trim().split(" ");
                        for (int j = 0; j < line.length; j++) {
                            matrix[i][j] = Double.parseDouble(line[j]);
                        }
                    }
                }
                System.out.println();
                return matrix;
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("File not found! Check path and try enter it again.");
            } catch (PermissionDeniedException permissionDeniedException) {
                System.err.println(permissionDeniedException.getMessage());
            }
        }
    }

    public static double[] gaussSolution(double[][] matrix) {
        try {
            int dimension = matrix.length;
            double[][] copyOfMatrix = new double[dimension][dimension + 1];
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension + 1; j++) {
                    copyOfMatrix[i][j] = matrix[i][j];
                }
            }
            for (int k = 0; k < dimension; k++) { //k-номер строки
                for (int i = 0; i < dimension + 1; i++) //i-номер столбца
                    copyOfMatrix[k][i] = copyOfMatrix[k][i] / matrix[k][k]; //Деление k-строки на первый член !=0 для преобразования его в единицу
                for (int i = k + 1; i < dimension; i++) { // i-номер следующей строки после k
                    double coefficient = copyOfMatrix[i][k] / copyOfMatrix[k][k]; //Коэффициент
                    for (int j = 0; j < dimension + 1; j++) {//j-номер столбца следующей строки после k
                        copyOfMatrix[i][j] = copyOfMatrix[i][j] - copyOfMatrix[k][j] * coefficient; //Зануление элементов матрицы ниже первого члена, преобразованного в единицу
                    }
                }
                for (int i = 0; i < dimension; i++) { //Обновление, внесение изменений в начальную матрицу
                    for (int j = 0; j < dimension + 1; j++) {
                        if (new Double(copyOfMatrix[i][j]).equals((Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY))
                                || (copyOfMatrix[i][j] * (-1) == 0)) {
                            matrix[i][j] = 0;
                        } else matrix[i][j] = copyOfMatrix[i][j];
                    }
                }
            }
            System.out.println("Your augmented matrix, reduced to triangular form:");
            printMatrix(matrix);
            double determinant = 1;
            for (int i = 0; i < matrix.length; i++) {
                determinant *= matrix[i][i];
            }
            if (determinant == 0) {
                throw new NoSolutionException();
            }
            //Обратный ход (Зануление верхнего правого угла)
            for (int k = dimension - 1; k > -1; k--) //k-номер строки
            {
                for (int i = dimension; i > -1; i--) { //i-номер столбца
                    copyOfMatrix[k][i] = copyOfMatrix[k][i] / matrix[k][k];
                }
                for (int i = k - 1; i > -1; i--) { //i-номер следующей строки после k
                    double coefficient = copyOfMatrix[i][k] / copyOfMatrix[k][k];
                    for (int j = dimension; j > -1; j--) //j-номер столбца следующей строки после k
                        copyOfMatrix[i][j] = copyOfMatrix[i][j] - copyOfMatrix[k][j] * coefficient;
                }
                //Отделяем от общей матрицы ответы
                double[] answers = new double[dimension];
                for (int i = 0; i < dimension; i++) {
                    answers[i] = copyOfMatrix[i][dimension];
                }
                return answers;
            }
        } catch (NoSolutionException noSolutionException) {
            System.err.println(noSolutionException.getMessage());
            System.exit(0);
        }
        return null;
    }
}
