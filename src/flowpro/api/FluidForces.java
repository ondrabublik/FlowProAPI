package flowpro.api;

import java.io.Serializable;

public class FluidForces implements Serializable {
    public boolean isEmpty;
    public double[][] totalTranslationForce;
    public double[][] totalRotationForce;
    public double[][] boundaryForce;
    public int[][] faceIndexes;
    public double[][] userDef;
    
    public FluidForces(double[][] totalTranslationForce, double[][] totalRotationForce, double[][] boundaryForce, int[][] faceIndexes, double[][] userDef){
        this.totalTranslationForce = totalTranslationForce;
        this.totalRotationForce = totalRotationForce;
        this.boundaryForce = boundaryForce;
        this.faceIndexes = faceIndexes;
        this.userDef = userDef;
    }
    
    public FluidForces(){
        isEmpty = true;
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
