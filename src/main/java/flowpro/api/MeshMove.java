
package flowpro.api;

import java.io.Serializable;

public class MeshMove implements Serializable {
    double[] translation;
    double[] rotation;
    double[][] deformationCoeffs;
    double[][] boundaryPoints;
	double[][] boundaryDisplacement;
    
    public MeshMove(double[] translation, double[] rotation, double[][] deformationCoeffs, double[][] boundaryPoints){
        this.translation = translation;
        this.rotation = rotation;
        this.deformationCoeffs = deformationCoeffs;
        this.boundaryPoints = boundaryPoints;
    }
	
	public MeshMove(double[] translation, double[] rotation, double[][] deformationCoeffs, double[][] boundaryPoints,
			double[][] boundaryDisplacement){
        this.translation = translation;
        this.rotation = rotation;
        this.deformationCoeffs = deformationCoeffs;
        this.boundaryPoints = boundaryPoints;
		this.boundaryDisplacement = boundaryDisplacement;
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

    public double[][] getBoundaryPoints() {
        return boundaryPoints;
    }
	
	public double[][] getBoundaryDisplacement() {
		return boundaryDisplacement;
	}
}