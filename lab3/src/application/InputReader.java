package application;

import calculations.FunctionManipulator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputReader {

    private final static Scanner scanner = new Scanner(System.in);

    public static FunctionManipulator getFunction() {
        System.out.println("List of functions:");
        System.out.println("1) " + FunctionManipulator.FIRST +
                         "\n2) " + FunctionManipulator.SECOND +
                         "\n3) " + FunctionManipulator.THIRD);
        System.out.print("Choose a number of function for integrating: ");
        while (true) {
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        return FunctionManipulator.FIRST;
                    case 2:
                        return FunctionManipulator.SECOND;
                    case 3:
                        return FunctionManipulator.THIRD;
                    default:
                        System.out.println("Number of function must be 1, 2 or 3.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Choose one of the suggested functions.");
                scanner.next();
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Incorrect enter.");
                System.exit(1);
            }
        }
    }

    public static double getBottomLimit() {
        System.out.print("Enter bottom limit: ");
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Bottom limit is a double number.");
                scanner.next();
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Incorrect enter.");
                System.exit(1);
            }
        }
    }

    public static double getTopLimit() {
        System.out.print("Enter top limit: ");
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Top limit is a double number.");
                scanner.next();
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Incorrect enter.");
                System.exit(1);
            }
        }
    }

    public static double getAccuracy() {
        double accuracy;
        System.out.print("Enter necessary accuracy: ");
        while (true) {
            try {
                accuracy = scanner.nextDouble();
                if (accuracy <= 0)
                    throw new InputMismatchException();
                return accuracy;
            } catch (InputMismatchException e) {
                System.out.println("Accuracy is a double number less than 0.");
                scanner.next();
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Incorrect enter.");
                System.exit(1);
            }
        }
    }

}