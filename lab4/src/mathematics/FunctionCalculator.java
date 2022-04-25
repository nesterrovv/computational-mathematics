package mathematics;

import java.util.ArrayList;
import java.util.List;

public class FunctionCalculator {

    public static List<Point> calculate(Function function, List<Double> newY) {
        List<Point> result = new ArrayList<>();
        List<Point> points = function.getPoints();
        for (int i = 0; i < points.size(); i++) {
            result.add(new Point(points.get(i).getX(), newY.get(i)));
        }
        return result;
    }

}