package flowpro.api;

import java.io.*;

/**
 *
 * @author obublik
 */

public interface Functional extends Serializable {
    
    public int getN();

    public void init(FlowProProperties props) throws IOException;
    
    public double[] insideValue(double[] W, double[] dW, ElementData elemData);
    
    public double[] boundaryValue(double[] W, double[] dW, double[] n, int TT, ElementData elemData);
    
    public double combineFunctionals(double[] functionals);   
}
