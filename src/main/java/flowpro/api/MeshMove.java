
package flowpro.api;

import java.io.Serializable;

public class MeshMove implements Serializable {
    double[] translation;
    double[] rotation;
    double[][] deformationCoeffs;
    double[][] boundaryPointsCoords;
    
    public MeshMove(double[] translation, double[] rotation, double[][] deformationCoeffs, double[][] boundaryPointsCoords){
        this.translation = translation;
        this.rotation = rotation;
        this.deformationCoeffs = deformationCoeffs;
        this.boundaryPointsCoords = boundaryPointsCoords;
    }
    
    public double[] getTranslation() {
        return translation;
    }

    public double[] getRotation() {
        return rotation;
    }

    public double[][] getDeformationCoefficients() {
        return deformationCoeffs;
    }

    public double[][] getboundaryPointsCoords() {
        return boundaryPointsCoords;
    }
}