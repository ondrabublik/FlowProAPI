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
public interface Dynamics extends Serializable {
    
    public void init(int nBodies, String simulationPath, String geometryPath, Equation eqn) throws IOException;
    
    public void computeBodyMove(double dt, double t, int newtonIter, FluidForces fluFor);
    
    public void nextTimeLevel();
    
    public MeshMove[] getMeshMove();
    
    public double[][] getCenter();
    
    public void savePositionsAndForces();
}
