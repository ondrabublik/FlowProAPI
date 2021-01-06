package flowpro.api;

import java.io.*;

public interface Equation extends Serializable {
    
    /**
     * Here all the necessary parameters for the model are loaded. It is called right after
     * an instance is created. This method is always called, thus must be implemented properly.
     * @param props contains parameters loaded from the text file parameters.txt
     * @throws IOException 
     */
    public void init(FlowProProperties props) throws IOException;
    
    /**
     * Defines the number of equations in the model. Vectors such as W, WR, WL or Ws will be
     * allocated such that their length equals to the number of equations. This method is always
     * called, thus must be implemented properly.
     * @return number of equations 
     */
    public int nEqs();
    
    /**
     * Defines the spatial dimension. This method is always called, thus must be implemented
     * properly.
     * @return dimension
     */
    public int dim();
    
    /**
     * Prescribes the boundary condition based on the boundary type. Method is always called, thus
     * must be implemented properly.
     * @param WL left value of the approximate solution at the boundary
     * @param n unit outward normal
     * @param boundaryType a negative integer which may correspond to wall, inlet, outlet etc.
     * @param elemData contains some parameters of the adjoined mesh element which may or may not
     * be useful
     * @return value at the boundary
     */
    public double[] boundaryValue(double[] WL, double[] n,
            int boundaryType, ElementData elemData);
    
    /**
     * Defines initial condition which is constant at the whole domain. This method is called
     * only if initial condition are not provided in the text file initW.txt.
     * @return initial value of the solution
     */
    public double[] constInitCondition();
    
    /**
     * Called ones at the beginning of the computation.
     * @param t
     * @param dt
     */
    public void setState(double t, double dt); // called ones at the begining of the iteration 
    
    /**
     * Return true if the Jacobi matrix of the equations is presented.
     * @return boolean
     */
    public boolean isEquationsJacobian();
    
    // convection term
    /**
     * True if the convective flux is presented
     * @return boolean
     */
    public boolean isConvective();
    public double[] convectiveFlux(double[] W, double[] n, ElementData elemData);
    public double[] numericalConvectiveFlux(double[] WL, double[] WR, double[] n, int TT, ElementData elemData);
    public double[] convectiveFluxJacobian(double[] W, double[] n, ElementData elemData);

    // diffusion term (viscosity)
    // convection term
    /**
     * True if the diffusive flux is presented
     * @return boolean
     */
    public boolean isDiffusive();
    public double[] diffusiveFlux(double[] W, double[] dW, double n[], ElementData elemData);
    public double[] numericalDiffusiveFlux(double[] W, double[] dW, double[] n, int TT, ElementData elemData); // direct discontinuous Galerkin
    public double[] diffusiveFluxJacobian(double[] W, double[] dW, double n[], ElementData elemData);

    // source term
    // convection term
    /**
     * True if the source term is presented
     * @return boolean
     */
    public boolean isSourcePresent();
    public double[] sourceTerm(double[] W, double[] dW, ElementData elemData);
    public double[] sourceTermJacobian(double[] W, double[] dW, ElementData elemData);
    
    /**
     * Function compute max eigenvalue.
     * @param W
     * @param elemData
     * @return max eigenvalue of the system of equations
     */
    public double maxEigenvalue(double[] W, ElementData elemData);
    
    public boolean isIPFace(int TT); // for penalty application  
	
	abstract public double pressure(double[] W); // to be replaced by normalStress

	public double[] stressVector(double[] W, double[] dW, double[] normal);

    public void saveReferenceValues(String filePath) throws IOException;
    
    public double[] getReferenceValues();
    
    public double[] getResults(double[] W, double[] dW, double[] X, String name);
    
    public double[] combineShockSensors(double[] shock);
}
