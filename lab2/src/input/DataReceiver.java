package input;

import java.util.*;

public class DataReceiver {

    public final double solveFirstEquation(double x) {
        return Math.pow(x, 2) + 5 * x + 7;
    }

    public final double solveSecondEquation(double x) {
        return Math.pow(x, 3) + Math.sqrt(x);
    }

    public final double solveFirstFuncFromFirstSystem(double x) {
        return Math.sin(x + 1) - x - 1.2;
    }

    public final double solveSecondFuncFromFirstSystem(double x) {
        return 1 - Math.cos(x) / 2 - x;
    }

    public final double solveFirstFuncFromSecondSystem(double x) {
        return Math.pow(x, 3) + Math.sqrt(x);
    }

    public final double solveSecondFuncFromSecondSystem(double x) {
        return Math.pow(x, 2) + 2 * x - 3;
    }

    public final double[] receiveFirstSystem(double x1, double x2) {
        double answer1 = Math.sin(x1 + 1) - x1 - 1.2;
        double answer2 = 1 - Math.cos(x2) / 2 - x2;
        return new double[] {answer1, answer2};
    }

    public final double[] receiveSecondSystem(double x1, double x2) {
        double answer1 = Math.pow(x1, 2) + 2 * x1 - 3;
        double answer2 = Math.pow(x2, 3) - 5;
        return new double[] {answer1, answer2};
    }

    public int receiveEquation() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You need to choose some equation from list for equation solver working demonstration.");
                System.out.println("Variants:");
                System.out.println("1.\tx^2 + 5x + 7 = 0;");
                System.out.println("2.\tx^3 + sqrt(x) = 0;");
                System.out.print("Enter equation number: ");
                int number = scanner.nextInt();
                if (!(number == 1 || number == 2)) throw new InputMismatchException();
                return number;
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Value must be a number! Try again!");
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Incorrect input.");
                System.exit(1);
            }
        }
    }

    public int receiveSystem() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You need to choose some system of nonlinear equations from list " +
                        "for equation solver working demonstration.");
                System.out.println("Variants:");
                System.out.println();
                System.out.println("#1.\nsin(x1 + 1) - x1 - 1.2 = 0\n1 - cos(x2)/2 - x2 = 0");
                System.out.println();
                System.out.println("#2.\nx1^3 + sqrt(x1) = 0\nx2^2 + 2 * x2 - 3 = 0");
                System.out.print("Enter equation number: ");
                int number = scanner.nextInt();
                if (!(number == 1 || number == 2)) throw new InputMismatchException();
                return number;
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Value must be a number! Try again!");
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Incorrect input.");
                System.exit(1);
            }
        }
    }

    public double[] receiveCoefficients() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("You need to enter a segment [a;b].");
                System.out.print("Enter \"a\" value: ");
                double a = scanner.nextDouble();
                System.out.print("Enter \"b\" value: ");
                double b = scanner.nextDouble();
                if (b < a) throw new ArithmeticException();
                System.out.print("Enter \"ε\" value is the accuracy with which it is necessary to find a solution to the equation: ");
                double e = scanner.nextDouble();
                return new double[]{a, b, e};
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Value must be a number! Try again!");
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Incorrect input.");
                System.exit(1);
            } catch (ArithmeticException arithmeticException) {
                System.err.println("\"a\" value must be lower than \"b\" value. Try again.");
            }
        }
    }

}
