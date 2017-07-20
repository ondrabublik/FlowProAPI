package flowpro.api;

import java.io.*;

public interface Equation extends Serializable {
    
    public void init(FlowProProperties props) throws IOException;
    public int nEqs();
    public int dim();
    public double[] constInitCondition();
    
    // convection term
    public boolean isConvective();
    public double[] convectiveFlux(double[] W, double Vs, double[] n, ElementData elemData);
    public double[] numericalConvectiveFlux(double WL[], double WR[], double Vs, double[] n, int TT, ElementData elemData);

    // diffusion term (viscosity)
    public boolean isDiffusive();
    public double[] diffusiveFlux(double[] W, double[] dW, double n[], ElementData elemData);
    public double[] numericalDiffusiveFlux(double WL[], double WR[], double dWL[], double dWR[], double n[], int TT, ElementData elemData);

    // source term
    public boolean isSourcePresent();
    public double[] sourceTerm(double[] W, double[] dW, ElementData elemData);
    
    public double maxEigenvalue(double[] W);
    
    public boolean isIPFace(int TT); // for penalty application

    public double[] boundaryValue(double[] WL, double[] u, double n[], int TT, ElementData elemData);

    public double pressure(double[] W);

    public void limitUnphysicalValues(double[] Ws, double[][] W, int nBasis);

    public void saveReferenceValues(String filePath) throws IOException;
    
    public double[] getReferenceValues();
    
    public double[] getResults(double[] W, String name);
}
