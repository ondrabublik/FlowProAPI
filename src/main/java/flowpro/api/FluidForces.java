package flowpro.api;

import java.io.Serializable;

public class FluidForces implements Serializable {
    public double[][] totalTranslationForce;
    public double[][] totalRotationForce;
    public double[][] boundaryForce; // nBoundFaces x dim
    public int[][] faceIndexes; // element index, face index, body number
    public double[][] userDef;
    
    public FluidForces(double[][] totalTranslationForce, double[][] totalRotationForce, double[][] boundaryForce, int[][] faceIndexes, double[][] userDef){
        this.totalTranslationForce = totalTranslationForce;
        this.totalRotationForce = totalRotationForce;
        this.boundaryForce = boundaryForce;
        this.faceIndexes = faceIndexes;
        this.userDef = userDef;
    }
    
    /**
     * Compute translation force acting the bodies.
     * @return 
     */
    public double[][] getTranslationForce() {
        return totalTranslationForce;
    }

    /**
     * Compute rotation moments acting the bodies.
     * @return 
     */
    public double[][] getRotationForce() {
        return totalRotationForce;
    }

    /**
     * @return forces acting the boundaries
     */
    public double[][] getBoundaryForce() {
        return boundaryForce;
    }

    public int[][] getFaceIndexes() {
        return faceIndexes;
    }
    
    public double[][] getUserDef() {
        return userDef;
    }
}
