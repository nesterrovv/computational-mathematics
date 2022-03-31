package methods;

import input.DataReceiver;

public class SimpleIterationMethodSolver {

    public void solveSystemOfEquations() {
        System.out.println("Fixed point iteration method for nonlinear equations system solving.");
        DataReceiver receiver = new DataReceiver();
        double[] coefficients = receiver.receiveCoefficients();
        double a = coefficients[0];
        double b = coefficients[1];
        double e = coefficients[2];
        int equationNumber = receiver.receiveSystem();
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("Initial guess is: " + a);
        System.out.println("Necessary accuracy is: " + e);
        System.out.println("Maximum iteration amount is: " + b);
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("Solving is started...");
        int step = 1;
        double x1;
        if (equationNumber == 1) {
            do {
                x1 = receiver.solveSecondFuncFromFirstSystem(a);
                System.out.println("Iteration #" + step + ". x1 = " + x1 + " and f(x1) = " + receiver.solveFirstFuncFromFirstSystem(x1));
                step += 1;
                if (step > b) {
                    System.out.println("Not convergent.");
                    System.exit(0);
                }
                a = x1;
            } while (Math.abs(receiver.solveFirstFuncFromFirstSystem(x1)) > e);
            System.out.println("Root is: " + x1);
        } else {
            do {
                x1 = receiver.solveSecondFuncFromSecondSystem(a);
                System.out.println("Iteration #" + step + ". x1 = " + x1 + " and f(x1) = " + receiver.solveFirstFuncFromSecondSystem(x1));
                step += 1;
                if (step > b) {
                    System.out.println("Not convergent.");
                    System.exit(0);
                }
                a = x1;
            } while (Math.abs(receiver.solveFirstFuncFromSecondSystem(x1)) > e);
            System.out.println("Root is: " + x1);
        }
    }

}
