import methods.BisectionMethodSolver;
import methods.ChordMethodSolver;
import methods.SimpleIterationMethodSolver;

/**
 * Main class of this program. Demonstrates program working
 */
public class Main {

    /**
     * Entry point. Runs demonstration of this lab work
     * @param args is system arguments. Not used here
     */
    public static void main(String[] args) {
        System.out.println("Lab work #2 demonstrating system is started!");
        System.out.println("\n\n\n\n\n");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("Task #1.1. Usage of bisection method for nonlinear equations solving:");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        BisectionMethodSolver bisectionMethodSolver = new BisectionMethodSolver();
        bisectionMethodSolver.solveEquation();
        System.out.println("\n\n\n\n\n");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("Task #1.2. Usage of chord method for nonlinear equations solving:");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        ChordMethodSolver chordMethodSolver = new ChordMethodSolver();
        chordMethodSolver.solveEquation();
        System.out.println("\n\n\n\n\n");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("Task #2. Usage of fixed point iteration method for nonlinear equations system solving::");
        System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        SimpleIterationMethodSolver simpleIterationMethodSolver = new SimpleIterationMethodSolver();
        simpleIterationMethodSolver.solveSystemOfEquations();
        System.out.println("\n\n\n\n\n");
        System.out.println("Lab work #2 demonstrating system is finished!");
    }

}
