package application;

import mathematics.Function;
import mathematics.Point;
import org.knowm.xchart.*;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.knowm.xchart.style.theme.GGPlot2Theme;
import java.awt.*;

/**
 * Class with application graphic part. Uses AWT and XChart libraries.
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/25/2022
 */
public class Graphics {

    /**
     * Method for drawing function graph
     * @param function is function for approximation
     * @param firstApproximation is first approximation function
     * @param secondApproximation is second approximation function
     * @param exclusion is exclusion point for function which was drawn
     */
    public static void drawGraphic(Function function, Function firstApproximation, Function secondApproximation,
                                   Point exclusion) {
        double[] xArray = function.getArrayX();
        double[] yArray = function.getArrayY();
        double[] yFirstApproximationData = firstApproximation.getArrayY();
        double[] xSecondApproximationData = secondApproximation.getArrayX();
        double[] ySecondApproximationData = secondApproximation.getArrayY();

        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("Function graph")
                .xAxisTitle("x value")
                .yAxisTitle("y value")
                .build();
        XYSeries functionDraw = chart.addSeries("Set of points", xArray, yArray);
        functionDraw.setLineStyle(SeriesLines.NONE);

        XYSeries firstApproximationDraw = chart.addSeries("Approximation", xArray, yFirstApproximationData);
        firstApproximationDraw.setMarker(SeriesMarkers.NONE);
        firstApproximationDraw.setLineStyle(SeriesLines.DASH_DASH);
        firstApproximationDraw.setLineColor(Color.BLUE);

        XYSeries secondApproximationDraw = chart.addSeries("Approximation after exclusion", xSecondApproximationData, ySecondApproximationData);
        secondApproximationDraw.setMarker(SeriesMarkers.NONE);
        secondApproximationDraw.setLineStyle(SeriesLines.DASH_DASH);
        secondApproximationDraw.setLineColor(Color.RED);

        XYSeries exclusionPoint = chart.addSeries("Exclusion Point", new double[]{exclusion.getX()}, new double[]{exclusion.getY()});
        exclusionPoint.setFillColor(Color.GREEN);

        chart.getStyler().setTheme(new GGPlot2Theme());
        new SwingWrapper(chart).displayChart();
    }
}
