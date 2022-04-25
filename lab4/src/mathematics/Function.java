package mathematics;

import java.util.List;

public class Function {

    private List<Point> points;

    public Function() {}

    public Function(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public double[] getArrayX() {
        return getPoints().stream()
                .mapToDouble(Point::getX)
                .toArray();
    }

    public double[] getArrayY() {
        return getPoints().stream().mapToDouble(Point::getY).toArray();
    }

}
