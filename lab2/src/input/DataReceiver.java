package input;

import java.util.*;

/**
 * Class for receiving all necessary data (coefficients, necessary accuracy, equations, system of equations)
 * from user
 * @author Ivan Nesterov
 * @version 1.0
 * @since 3/29/2022
 */
public class DataReceiver {

    /**
     * Method for counting value of first function
     * @param x is function argument
     * @return function value
     */
    public final double solveFirstEquation(double x) {
        return Math.pow(x, 2) + 5 * x + 7;
    }

    /**
     * Method for counting value of second function
     * @param x is function argument
     * @return function value
     */
    public final double solveSecondEquation(double x) {
        return Math.pow(x, 3) + Math.sqrt(x);
    }

    /**
     * Method for counting value of first function from first system of equations
     * @param x is function argument
     * @return function value
     */
    public final double solveFirstFuncFromFirstSystem(double x) {
        return Math.sin(x + 1) - x - 1.2;
    }

    /**
     * Method for counting value of second function from first system of equations
     * @param x is function argument
     * @return function value
     */
    public final double solveSecondFuncFromFirstSystem(double x) {
        return 1 - Math.cos(x) / 2 - x;
    }

    /**
     * Method for counting value of first function from second system of equations
     * @param x is function argument
     * @return function value
     */
    public final double solveFirstFuncFromSecondSystem(double x) {
        return Math.pow(x, 3) + Math.sqrt(x);
    }

    /**
     * Method for counting value of second function from second system of equations
     * @param x is function argument
     * @return function value
     */
    public final double solveSecondFuncFromSecondSystem(double x) {
        return Math.pow(x, 2) + 2 * x - 3;
    }

    /**
     * Method for receving number of equation from list of possible equations. Entered by user.
     * @return number of equation
     */
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

    /**
     * Method for receving number of equations system from list of possible equations. Entered by user.
     * @return number of equations system
     */
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

    /**
     * Method for receving coefficients a,b (is segment for root searching) and e (is necessary accuracy)
     * @return array with a,b,e coefficients
     */
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
