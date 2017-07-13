package flowpro.api;

import java.io.*;

public interface Equation extends Serializable {
    
    public void init(FlowProProperties props) throws IOException;
    public int nEqs();
    public int dim();
    public double[] constInitCondition();
    
    // convection term
    public boolean convectionTerm();
    public double[] flux(double[] W, double Vs, double[] n, ElementData elemData);
    public double[] normalFlux(double WL[], double WR[], double Vs, double[] n, int TT, ElementData elemData);

    // diffusion term (viscosity)
    public boolean diffusionTerm();
    public double[] normalViscousFlux(double WL[], double WR[], double dWL[], double dWR[], double n[], int TT, ElementData elemData);
    public double[] viscousFlux(double[] W, double[] dW, double n[], ElementData elemData);

    // source term
    public boolean sourceTerm();
    public double[] source(double[] W, double[] dW, ElementData elemData);
    
    public double lambdaMax(double[] W);
    
    public boolean isIPFace(int TT); // for penalty application

    public double[] boundaryValue(double[] WL, double[] u, double n[], int TT, ElementData elemData);

    public double pressure(double[] W);

    public void limitUnphysicalValues(double[] Ws, double[][] W, int nBasis);

    public void saveReferenceValues(String filePath) throws IOException;
    
    public double[] getReferenceValues();
    
    public double getResults(double[] W);
}
