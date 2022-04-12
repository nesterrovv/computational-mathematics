package application;

import calculations.FunctionManipulator;
import calculations.SimpsonMethodSolver;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Simpson method solver system has been started!");
        SimpsonMethodSolver solver = new SimpsonMethodSolver(InputReader.getFunction(), InputReader.getBottomLimit(),
                                                             InputReader.getTopLimit(), InputReader.getAccuracy());
        if (solver.getTopLimit() * solver.getBottomLimit() < 0 &&
                                   solver.getFunction().equals(FunctionManipulator.THIRD)) {
            System.out.println("Cannot divide by zero.");
        } else {
            switch (solver.integrate()) {
                case -1:
                    System.out.println("Accuracy cannot be reached. No solution.");
                    break;
                case 0:
                    System.out.print("Result: ");
                    System.out.printf("%.3f\n", solver.getResult());
                    System.out.print("Error: ");
                    System.out.printf("%.10f\n", solver.getError());
                    System.out.println("Steps amount: " + solver.getSteps());
                    break;
                case 1:
                    System.out.println("Limits are equal.");
                    System.out.println("Result: " + solver.getResult());
                    System.out.println("Error: " + solver.getError());
                    System.out.println("Steps amount: " + solver.getSteps());
            }
        }
    }

}