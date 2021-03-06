package user;

import approximationMethods.Approximation;
import approximationMethods.Approximations;
import mathematics.Function;
import mathematics.Functions;
import mathematics.Point;
import java.util.*;

/**
 * Class for working with user input and with output for user
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public class IOManipulator {

    /** Scanner for reading from stdin */
    private static final Scanner scanner = new Scanner(System.in);

    /** Method for printing hello-string for user */
    public static void introduction() {
        System.out.println("Lab work #4. Least squares approximation method application by I.Nesterov is started!\n");
    }

    /** Method for printing set of possible functions for user */
    public static void showFunctions() {
        Map<Integer, Function> functions = Functions.getFunctions();
        for (int i = 1; i <= functions.size(); i++) {
            System.out.println("Set of values " + i);
            showTable(functions.get(i));
        }
    }

    /** Method for printing table of points for user */
    private static void showTable(Function function) {
        System.out.print("x:| ");
        List<Point> points = function.getPoints();
        for (Point point : points) {
            System.out.print(point.getX() + " ");
        }
        System.out.println("|");
        System.out.print("y:| ");
        for (Point point : points) {
            System.out.print(point.getY() + " ");
        }
        System.out.println("|");
    }

    /**
     * Method for receiving number of function from user
     * @return number of function which is necessary for user
     */
    public static int getFunctionChoose() {
        while (true) {
            try {
                System.out.println("Enter number of function for approximation. Is value from set {1, 2, 3}, \n" +
                        "where set of (x,y) points for each are:");
                showFunctions();
                int enter = 0;
                try {
                    enter = scanner.nextInt();
                } catch (InputMismatchException inputMismatchException) {
                    System.err.println("Bad input. Value must be a number.");
                    System.exit(1);
                }
                System.out.print("Value cannot be empty. ");
                String xx = Long.toString(enter);
                if (enter > 3 || enter < 1) {
                    System.out.println("Is value from set {1, 2, 3}. Try again. ");
                    continue;
                }
                if (xx.equals("") ) {
                    System.out.println("This value cannot be empty. Try again. ");
                    continue;
                }
                return enter;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a number from set {1, 2, 3}. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was finished successfully!");
                System.exit(0);
            }
        }
    }

    /**
     * Method for receiving number of approximation function from user
     * @return number of approximation function which is necessary for user
     */
    public static int getApproximationChoose() {
        while (true) {
            try {
                System.out.println("Enter number of function for approximation. Is value from set {1, 2, 3}, \n" +
                        "where set of (x,y) points for each are:");
                printAllTypesOfApproximations();
                int approximation = 0;
                try {
                    approximation = scanner.nextInt();
                } catch (InputMismatchException inputMismatchException) {
                    System.err.println("Bad input. Value must be a number.");
                    System.exit(1);
                }
                System.out.print("Value cannot be empty. ");
                String xx = Long.toString(approximation);
                if (approximation > 3 || approximation < 1) {
                    System.out.println("Is value from set {1, 2, 3}. Try again. ");
                    continue;
                }
                if (xx.equals("") ) {
                    System.out.println("This value cannot be empty. Try again. ");
                    continue;
                }
                return approximation;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("This value must be a number from set {1, 2, 3}. Try again.");
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Program was finished successfully!");
                System.exit(0);
            }
        }
    }

    /** Method for printing set of possible approximation functions for user */
    public static void printAllTypesOfApproximations() {
        for (Map.Entry<Integer, Approximation> entry : Approximations.getApproximations().entrySet()) {
            System.out.println(entry.getKey() + "." + entry.getValue().typeOfApproximation());
        }
    }

    /**
     * Method for parameters printing
     * @param params is array of parameters
     */
    public static void printParams(double[] params) {
        for (int i = 0; i < params.length; i++) {
            System.out.println("a[" + i + "]= " + params[i]);
        }
        System.out.println();
    }

    /**
     * Method for deviation printing
     * @param deviation is value of deviation
     */
    public static void printDeviation(double deviation) {
        System.out.println("Deviation measure: " + deviation);
    }

}
