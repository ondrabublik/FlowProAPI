package flowpro.api;

import java.io.Serializable;

/**
 *
 * @author obublik
 */
public class ElementData implements Serializable {
    
    public double currentWallDistance;
    public double[] currentX;
    public double[] meshVelocity;
    public double currentT;
    public double[] integralMonitor;
    public double[] externalField;
    
    public ElementData(int dim) {
        currentX = new double[dim];
        meshVelocity = new double[dim];
    }
}
