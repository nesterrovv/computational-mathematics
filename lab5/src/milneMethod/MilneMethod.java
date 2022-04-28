package milneMethod;

import org.nfunk.jep.JEP;

import java.util.ArrayList;
import java.util.List;

public class MilneMethod {
    JEP parser;
    Double h = 0.1;
    Double rightBorder;
    Double leftBorder;
    Double epsilon;
    List<Double> x;
    List<Double> y;
    List<Double> f;
    int n;

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

    public Double getYRungeKutta(int i) {
        x.add(i, x.get(i-1)+h);
        Double k0 = h * f(x.get(i-1), y.get(i-1));
        Double k1 = h * f(x.get(i-1) + h / 2, y.get(i-1) + k0 / 2);
        Double k2 = h * f(x.get(i-1) + h / 2, y.get(i-1) + k1 / 2);
        Double k3 = h * f(x.get(i-1) + h, y.get(i-1) + k2);
        return y.get(i-1) + (k0 + 2 * k1 + 2 * k2 + k3) / 6;
    }

    public Double f(Double x, Double y) {
        parser.addVariable("x", x);
        parser.addVariable("y", y);
        return parser.getValue();
    }

    public int calculateN (){
        double n = (rightBorder - leftBorder)/h;
        return (int)n;
    }

    public List<Double> getXList() {
        return x;
    }

    public Double getH() {
        return h;
    }

    public int getN(){
        return n;
    }

    public Double getLeftBorder() {
        return leftBorder;
    }

    public Double getRightBorder() {
        return rightBorder;
    }
}