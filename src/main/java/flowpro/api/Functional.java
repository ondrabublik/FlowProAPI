package flowpro.api;

import java.io.*;

/**
 *
 * @author obublik
 */

public interface Functional extends Serializable {
    
    /**
     * 
     * @return number of functionals
     */
    public int getN();

    public void init(FlowProProperties props) throws IOException;
    
    /**
     * Value of the functional inside a element.
     * @param W
     * @param dW
     * @param elemData
     * @return 
     */
    public double[] insideValue(double[] W, double[] dW, ElementData elemData);
    
    /**
     * Value of the functional on the element boundary.
     * @param W
     * @param dW
     * @param n
     * @param TT
     * @param elemData
     * @return
     */
    public double[] boundaryValue(double[] W, double[] dW, double[] n, int TT, ElementData elemData);
    
    /**
     * Combine functional together to get one functional.
     * @param functionals
     * @return combined functional
     */
    public double combineFunctionals(double[] functionals);   
}
