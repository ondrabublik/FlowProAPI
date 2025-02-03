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
public interface DomainTransformationObject extends Serializable {
    
    void init(FlowProProperties props) throws IOException ;
    
    double[] transform(double[] X);
    
    Complex[] transformComplex(Complex[] X);
}
