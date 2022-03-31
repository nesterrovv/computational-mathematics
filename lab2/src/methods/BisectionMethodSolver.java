package methods;

import input.DataReceiver;

/**
 * Class with using bisection method for equations solving
 * @author Ivan Nesterov
 * @version 1.0
 * @since 3/29/2022
 */
public class BisectionMethodSolver {

    /**
     * Method with bisection method realization. Prints solution to stdout
     */
    public void solveEquation() {
        DataReceiver receiver = new DataReceiver();
        double[] coefficients = receiver.receiveCoefficients();
        double a = coefficients[0];
        double b = coefficients[1];
        double e = coefficients[2];
        int equationNumber = receiver.receiveEquation();
        if (equationNumber == 1) {
            while (true) {
                double x = (a + b) / 2;
                if (receiver.solveFirstEquation(a) * receiver.solveFirstEquation(x) < 0) {
                    b = x;
                } else if (receiver.solveFirstEquation(x) * receiver.solveFirstEquation(b) < 0) {
                    a = x;
                }
                if (Math.abs(b - a) < 2 * e) {
                    continue;
                } else {
                    x = (a + b) / 2;
                    if (receiver.solveFirstEquation(x) == 0) {
                        System.out.println("x = " + x + ". Is exact value.");
                    } else System.out.println("x = " + x + ". Is approximate value accurate to ε = " + e + ".");
                    break;
                }
            }
        } else if (equationNumber == 2) {
            while (true) {
                double x = (a + b) / 2;
                if (receiver.solveSecondEquation(a) * receiver.solveSecondEquation(x) < 0) {
                    b = x;
                } else if (receiver.solveSecondEquation(x) * receiver.solveSecondEquation(b) < 0) {
                    a = x;
                }
                if (Math.abs(b - a) < 2 * e) {
                    continue;
                } else {
                    x = (a + b) / 2;
                    if (receiver.solveSecondEquation(x) == 0) {
                        System.out.println("x = " + x + ". Is exact value.");
                    } else System.out.println("x = " + x + ". Is approximate value accurate to ε = " + e + ".");
                    break;
                }
            }
        } else System.out.println("Incorrect equation number.");
    }

}
