package approximationMethods;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for storing set of possible approximation functions
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public class Approximations {

    /** map for storing number and type of approximation function */
    private static final Map<Integer, Approximation> approximations;

    /** Initialization block */
    static {
        approximations = new HashMap<>();
        approximations.put(1, new LinearApproximation());
        approximations.put(2, new QuadraticApproximation());
        approximations.put(3, new ExponentialApproximation());
    }

    /**
     * Method for receiving approximation function
     * @param number is number of function for receiving
     * @return necessary approximation function
     */
    public static Approximation getApproximation(int number) {
        return approximations.get(number);
    }

    /**
     * Method for receiving all approximation functions
     * @return map of all approximation functions
     */
    public static Map<Integer, Approximation> getApproximations() {
        return approximations;
    }

}
