package flowpro.api;

import java.io.Serializable;

public class FluidForces implements Serializable {
	
	public boolean isElastic;

	/** Total force F = [Fx, Fy, Fz] in 3D and F = [Fx, Fy] in 2D acting on the body. */
	public double[] force;
	
	/** Total torque T = [Tx, Ty, Tz] in 3D and T = [Tz] in 2D acting on the body. */
	public double[] torque;
	
	/** Stress vectors in various points along the boundary of the structure. */
	public double[][] stressVectors;
	
	/** Coordinates of the position where the stress vectors act. */
	public double[][] stressVectorPositions;
	
	public FluidForces() {}

	public FluidForces(double[] totalTranslationForce, double[] totalRotationForce) {
		this.force = totalTranslationForce;
		this.torque = totalRotationForce;
		this.isElastic = false;
	}
	
	public FluidForces(double[][] stressVectors, double[][] stressVectorPositions) {
		this.stressVectors = stressVectors;
		this.stressVectorPositions = stressVectorPositions;
		this.isElastic = true;
	}
}
