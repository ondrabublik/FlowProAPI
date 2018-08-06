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
    
    public double[][] getTranslationForce() {
        return totalTranslationForce;
    }

    public double[][] getRotationForce() {
        return totalRotationForce;
    }

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
