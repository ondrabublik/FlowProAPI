package flowpro.api;

import java.io.Serializable;

/**
 *
 * @author obublik
 */
public class ElementData implements Serializable {
    
    public double currentWallDistance;
    public double[] currentX;
    public double currentT;
    
    public ElementData(int dim) {
        currentX = new double[dim];
    }
}
