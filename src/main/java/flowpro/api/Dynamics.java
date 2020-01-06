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
    
    /**
     * Compute motion of the body.
     * @param dt time step
     * @param t time
     * @param newtonIter
     * @param fluFor object containing forces actink the body
     */
    public void computeBodyMove(double dt, double t, int newtonIter, FluidForces fluFor);
    
    /**
     * Move body to next position.
     */
    public void nextTimeLevel();
    
    /**
     * Compute mesh deformation.
     * @return 
     */
    public MeshMove[] getMeshMove();
    
    public double[][] getCenter();
    
    public void savePositionsAndForces();
}
