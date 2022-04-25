package approximationMethods;

import java.util.HashMap;
import java.util.Map;

public class Approximations {

    private static final Map<Integer, Approximation> approximations;

    static {
        approximations = new HashMap<>();
        approximations.put(1, new LinearApproximation());
        approximations.put(2, new QuadraticApproximation());
        approximations.put(3, new ExponentialApproximation());
    }

    public static Approximation getApproximation(int number) {
        return approximations.get(number);
    }

    public static Map<Integer, Approximation> getApproximations() {
        return approximations;
    }

}
