package milneMethod;

import org.nfunk.jep.JEP;

import java.util.ArrayList;
import java.util.List;

/**
 * Class with Milne numerical method implementation.
 * @author Ivan Nesterov
 * @version 1.0
 * @since 4/30/2022
 */
public class MilneMethod {

    /** Tool for parsing math expression to java code */
    JEP parser;
    /** Length of one step for calculating */
    Double h = 0.1;
    /** Value of right border of interval for function calculating */
    Double rightBorder;
    /** Value of left border of interval for function calculating */
    Double leftBorder;
    /** Value of necessary accuracy */
    Double epsilon;
    /** List of x coordinate values */
    List<Double> x;
    /** List of y coordinate values */
    List<Double> y;
    /** List of function values */
    List<Double> f;
    /** Amount of steps */
    int n;

    /**
     * Constructor of this class
     * @param parser is necessary object of JEP parser
     * @param x0 is x value, where x is one of given initial conditions
     * @param y0 is y value, where y is one of given initial conditions
     * @param border is value of right border of interval
     * @param eps is necessary accuracy for calculating
     */
    public MilneMethod(JEP parser, Double x0, Double y0, Double border, Double eps)  {
        this.parser = parser;
        this.rightBorder = border;
        this.leftBorder = x0;
        this.epsilon = eps;
        x = new ArrayList<>();
        y = new ArrayList<>();
        f = new ArrayList<>();
        x.add(0, x0);
        y.add(0, y0);
        f.add(0, f(x.get(0), y.get(0)));
        h = (rightBorder - leftBorder)/10;
    }

    /** Method for list of y coordinate values defining
     * @return list of y coordinate values
     */
    public List<Double> getYList() {
        n = calculateN();
        for (int i = 1; i < n+1; i++){
            if (i == 1 || i == 2 || i ==3){
                y.add(i,getYRungeKutta(i));
                f.add(i,f(x.get(i), y.get(i)));
            }else{
                x.add(i, x.get(i-1)+h);
                Double yPredict = y.get(i-4) + 4.0 / 3.0 * h * (2 * f.get(i-1) - f.get(i-2) + 2 * f.get(i-3));
                Double yCorrect = y.get(i-2) + h / 3.0 * (f(x.get(i), yPredict) + 4 * f.get(i-1) + f.get(i-2));
                double currentEpsilon = Math.abs(yCorrect - yPredict)/29.0;
                if (currentEpsilon <= epsilon){
                    y.add(i, yCorrect);
                    f.add(i, f(x.get(i), y.get(i)));
                }else{
                    h = h/2.0;
                    n = calculateN();
                    i = 0;
                    Double x0 = x.get(0);
                    Double y0 = y.get(0);
                    x.clear();
                    y.clear();
                    f.clear();
                    x.add(0, x0);
                    y.add(0, y0);
                    f.add(0, f(x.get(0), y.get(0)));
                }
            }
        }
        return y;
    }

    /** Runge-Kutta numerical method implementation.
     * Used as a starter of Milne numerical method.
     * @param i is number of iteration
     * @return value of necessary y coordinate
     */
    public Double getYRungeKutta(int i) {
        x.add(i, x.get(i-1)+h);
        Double k0 = h * f(x.get(i-1), y.get(i-1));
        Double k1 = h * f(x.get(i-1) + h / 2, y.get(i-1) + k0 / 2);
        Double k2 = h * f(x.get(i-1) + h / 2, y.get(i-1) + k1 / 2);
        Double k3 = h * f(x.get(i-1) + h, y.get(i-1) + k2);
        return y.get(i-1) + (k0 + 2 * k1 + 2 * k2 + k3) / 6;
    }

    /** Method for function value counting
     * @param x is x value
     * @param y is y value
     * @return function value
     */
    public Double f(Double x, Double y) {
        parser.addVariable("x", x);
        parser.addVariable("y", y);
        return parser.getValue();
    }

    /** Method for steps amount counting
     * @return steps amount
     */
    public int calculateN (){
        double n = (rightBorder - leftBorder)/h;
        return (int)n;
    }


    /** X field getter
     * @return x field value
     */
    public List<Double> getXList() {
        return x;
    }

    /** H field getter
     * @return h field value
     */
    public Double getH() {
        return h;
    }

    /** N field getter
     * @return n field value
     */
    public int getN(){
        return n;
    }

    /** Left border field getter
     * @return left border field value
     */
    public Double getLeftBorder() {
        return leftBorder;
    }

    /** Right border field getter
     * @return right border field value
     */
    public Double getRightBorder() {
        return rightBorder;
    }

}