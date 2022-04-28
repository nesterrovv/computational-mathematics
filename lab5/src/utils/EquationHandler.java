package utils;

import exceptions.InvalidDataException;
import milneMethod.MilneMethod;
import org.nfunk.jep.JEP;

public class EquationHandler {
    String stringF;
    JEP parser;
    Double eps;
    Double x0;
    Double y0;
    Double border;


    public EquationHandler(String stringF, String stringAccuracy, String x0text, String y0text, String bortext) throws InvalidDataException {
        this.stringF = stringF;
        try {
            Double.parseDouble(stringAccuracy);
            if (Double.parseDouble(stringAccuracy) < 1 && Double.parseDouble(stringAccuracy) > 0) {
                this.eps = Double.parseDouble(stringAccuracy);
            }
            JEP parser = new JEP();
            parser.addStandardFunctions();
            parser.addStandardConstants();
            parser.addVariable("x", 0);
            parser.addVariable("y", 0);
            parser.parseExpression(stringF);
            parser.getValue();
            this.parser = parser;
            x0 = Double.parseDouble(x0text);
            y0 = Double.parseDouble(y0text);
            border = Double.parseDouble(bortext);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidDataException("Incorrect input. Please try again.");
        }
    }

    public MilneMethod getMilneSolver(){
        return new MilneMethod(parser,x0,y0,border,eps);
    }
}