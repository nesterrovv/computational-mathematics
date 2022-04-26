package application;

import user.IOManipulator;

/**
 * Main class of this lab work. Starts application logic.
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public class Main {

    /**
     * Method for starting application logic.
     * @param args is command prompt arguments. Not used here.
     */
    public static void main(String[] args) {
        IOManipulator.introduction();
        LeastSquaresMethod.leastSquaresMethodRunner();
    }

}