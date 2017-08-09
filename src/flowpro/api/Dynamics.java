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
public interface Dynamics extends Serializable  {
    
    public void init(int nBodies, String simulationPath, String geometryPath, FlowProProperties par, Equation eqn) throws IOException;
    
    public void nextTimeLevel(double dt, double t, double[][] Force, double[][] Momentum);
    
    public double[][] getMovement();
    
    public double[][] getAngleMovement();
    
    public double[][] getCenter();
    
    public void savePositionsAndForces(double[][] userDef);
}