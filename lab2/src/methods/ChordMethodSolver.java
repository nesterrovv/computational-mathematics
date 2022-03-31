package methods;

import input.DataReceiver;

/**
 * Class with using chord method for equations solving
 * @author Ivan Nesterov
 * @version 1.0
 * @since 3/29/2022
 */
public class ChordMethodSolver {

    /**
     * Method with chord method realization. Prints solution to stdout
     */
    public void solveEquation() {
        DataReceiver receiver = new DataReceiver();
        double x_next = 0;
        double tmp;
        double[] coefficients = receiver.receiveCoefficients();
        double a = coefficients[0];
        double b = coefficients[1];
        double e = coefficients[2];
        int equationNumber = receiver.receiveEquation();
        if (equationNumber == 1) {
            do {
                tmp = x_next;
                x_next = b - receiver.solveFirstEquation(b) * (a - b) / (receiver.solveFirstEquation(a) -
                        receiver.solveFirstEquation(b));
                a = b;
                b = tmp;
            } while (Math.abs(x_next - b) > e);
        }
       else {
            do {
                tmp = x_next;
                x_next = b - receiver.solveSecondEquation(b) * (a - b) /
                        (receiver.solveSecondEquation(a) - receiver.solveSecondEquation(b));
                a = b;
                b = tmp;
            } while (Math.abs(x_next - b) > e);
        }
        if (receiver.solveFirstEquation(x_next) == 0) {
            System.out.println("x = " + x_next + ". Is exact value.");
        } else System.out.println("x = " + x_next + ". Is approximate value accurate to ε = " + e + ".");
    }

}
