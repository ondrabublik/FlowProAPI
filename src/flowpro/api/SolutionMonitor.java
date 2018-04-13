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

    public int getNumberOfMonitoredValues();

    public double[] insideValue(double[] W, double[] dW, ElementData elemData);

    public double[] boundaryValue(double[] W, double[] dW, double[] n, int TT, ElementData elemData);
}
