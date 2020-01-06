/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowpro.api;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author obublik
 */
public interface SolutionMonitor extends Serializable {

    public void init(FlowProProperties props) throws IOException;

    /**
     * @return number of monitored values
     */
    public int getNumberOfMonitoredValues();

    /**
     * Compute monitored values inside element.
     * @param W
     * @param dW
     * @param elemData
     * @return 
     */
    public double[] insideValue(double[] W, double[] dW, ElementData elemData);

    /**
     * Compute monitored values on the element boundary.
     * @param W
     * @param dW
     * @param n
     * @param TT
     * @param elemData
     * @return 
     */
    public double[] boundaryValue(double[] W, double[] dW, double[] n, int TT, ElementData elemData);
    
    /**
     * Combination of monitored values.
     * @param solutionMonitorValues 
     */
    public void combineMonitoredValues(double[] solutionMonitorValues);
}
