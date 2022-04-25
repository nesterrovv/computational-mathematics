package mathematics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Functions {

    private static final Map<Integer, Function> functions;

    static {
        functions = new HashMap<>();
        functions.put(1, new Function(Arrays.asList(
                new Point(1, 7.5),
                new Point(2, 9.5),
                new Point(3, 11.5),
                new Point(4, 12.5),
                new Point(5, 14.5),
                new Point(6, 17.5),
                new Point(7, 18.5),
                new Point(8, 20.5)
        )));
        functions.put(2, new Function(Arrays.asList(
                new Point(1.1, 3.5),
                new Point(2.8, 4.7),
                new Point(3.7, 5.23),
                new Point(4.5, 6.9),
                new Point(5.4, 9.1),
                new Point(6.8, 12.8),
                new Point(7.5, 16.4)
        )));
        functions.put(3, new Function(Arrays.asList(
                new Point(1.0, 2.73),
                new Point(2.4, 5.12),
                new Point(3.7, 7.74),
                new Point(5.2, 8.91),
                new Point(5.6, 10.59),
                new Point(6.8, 12.75),
                new Point(7.5, 13.43)
        )));
    }

    public static Function getFunction(int choose) {
        if (choose <= 1 || choose > functions.size()) {
            choose = 1;
        }
        return functions.get(choose);
    }

    public static Map<Integer, Function> getFunctions() {
        return functions;
    }

}