/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowpro.api;

/*
 * 
 * @author      Abdul Fatir
 * @version		1.2
 * 
 */
public class Complex
{
	/**
	* Used in <code>format(int)</code> to format the complex number as x+yi
	*/
	public static final int XY = 0;
	/**
	* Used in <code>format(int)</code> to format the complex number as R.cis(theta), where theta is arg(z)
	*/
	public static final int RCIS = 1;
	/**
	* The real, Re(z), part of the <code>Complex</code>.
	*/
	private double real;
	/**
	* The imaginary, Im(z), part of the <code>Complex</code>.
	*/
	private double imaginary;
	/**
	* Constructs a new <code>ComplexNumber</code> object with both real and imaginary parts 0 (z = 0 + 0i).
	*/
	public Complex()
	{
		real = 0.0;
		imaginary = 0.0;
	}
	
	/**
	* Constructs a new <code>ComplexNumber</code> object.
	* @param real the real part, Re(z), of the complex number
	* @param imaginary the imaginary part, Im(z), of the complex number
	*/
	
	public Complex(double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}
	
	/**
	* Adds another <code>Complex</code> to the current complex number.
	* @param z the complex number to be added to the current complex number
	*/
	
	public void add(Complex z)
	{
		set(add(this,z));
	}
	
	/**
	* Subtracts another <code>Complex</code> from the current complex number.
	* @param z the complex number to be subtracted from the current complex number
	*/
	
	public void subtract(Complex z)
	{
		set(subtract(this,z));
	}
	
	/**
	* Multiplies another <code>Complex</code> to the current complex number.
	* @param z the complex number to be multiplied to the current complex number
	*/
	
	public void multiply(Complex z)
	{
		set(multiply(this,z));
	}
	/**
	* Divides the current <code>Complex</code> by another <code>Complex</code>.
	* @param z the divisor
	*/	
	public void divide(Complex z)
	{
		set(divide(this,z));
	}
	/**
	* Sets the value of current complex number to the passed complex number.
	* @param z the complex number
	*/
	public void set(Complex z)
	{
		this.real = z.real;
		this.imaginary = z.imaginary;
	}
	/**
	* Adds two <code>Complex</code>.
	* @param z1 the first <code>Complex</code>.
	* @param z2 the second <code>Complex</code>.
	* @return the resultant <code>Complex</code> (z1 + z2).
	*/
	public static Complex add(Complex z1, Complex z2)
	{
		return new Complex(z1.real + z2.real, z1.imaginary + z2.imaginary);
	}
	
        public static Complex copy(Complex z){
            return new Complex(z.getRe(),z.getIm());
        }
        
	/**
	* Subtracts one <code>Complex</code> from another.
	* @param z1 the first <code>Complex</code>.
	* @param z2 the second <code>Complex</code>.
	* @return the resultant <code>Complex</code> (z1 - z2).
	*/	
	public static Complex subtract(Complex z1, Complex z2)
	{
		return new Complex(z1.real - z2.real, z1.imaginary - z2.imaginary);
	}
	/**
	* Multiplies one <code>Complex</code> to another.
	* @param z1 the first <code>Complex</code>.
	* @param z2 the second <code>Complex</code>.
	* @return the resultant <code>Complex</code> (z1 * z2).
	*/	
	public static Complex multiply(Complex z1, Complex z2)
	{
		double _real = z1.real*z2.real - z1.imaginary*z2.imaginary;
		double _imaginary = z1.real*z2.imaginary + z1.imaginary*z2.real;
		return new Complex(_real,_imaginary);
	}
	/**
	* Divides one <code>Complex</code> by another.
	* @param z1 the first <code>Complex</code>.
	* @param z2 the second <code>Complex</code>.
	* @return the resultant <code>Complex</code> (z1 / z2).
	*/		
	public static Complex divide(Complex z1, Complex z2)
	{
		Complex output = multiply(z1,z2.conjugate());
		double div = Math.pow(z2.mod(),2);
		return new Complex(output.real/div,output.imaginary/div);
	}

	/**
	* The complex conjugate of the current complex number.
	* @return a <code>Complex</code> object which is the conjugate of the current complex number
	*/
	
	public Complex conjugate()
	{
		return new Complex(this.real,-this.imaginary);
	}
	
	/**
	* The modulus, magnitude or the absolute value of current complex number.
	* @return the magnitude or modulus of current complex number
	*/
	
	public double mod()
	{
		return Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imaginary,2));
	}
	
	/**
	* The square of the current complex number.
	* @return a <code>Complex</code> which is the square of the current complex number.
	*/
	
	public Complex square()
	{
		double _real = this.real*this.real - this.imaginary*this.imaginary;
		double _imaginary = 2*this.real*this.imaginary;
		return new Complex(_real,_imaginary);
	}
	/**
	* @return the complex number in x + yi format
	*/
	@Override
	public String toString()
	{
		String re = this.real+"";
		String im = "";
		if(this.imaginary < 0)
			im = this.imaginary+"i";
		else
			im = "+"+this.imaginary+"i";
		return re+im;
	}
	/**
	* Calculates the exponential of the <code>Complex</code>
	* @param z The input complex number
	* @return a <code>Complex</code> which is e^(input z)
	*/
	public static Complex exp(Complex z)
	{
		double a = z.real;
		double b = z.imaginary;
		double r = Math.exp(a);
		a = r*Math.cos(b);
		b = r*Math.sin(b);
		return new Complex(a,b);
	}
	/**
	* Calculates the <code>Complex</code> to the passed integer power.
	* @param z The input complex number
	* @param power The power.
	* @return a <code>Complex</code> which is (z)^power
	*/
	public static Complex pow(Complex z, int power)
	{
		Complex output = new Complex(z.getRe(),z.getIm());
		for(int i = 1; i < power; i++)
		{
			double _real = output.real*z.real - output.imaginary*z.imaginary;
			double _imaginary = output.real*z.imaginary + output.imaginary*z.real;
			output = new Complex(_real,_imaginary);
		}
		return output;
	}
	/**
	* Calculates the sine of the <code>Complex</code>
	* @param z the input complex number
	* @return a <code>Complex</code> which is the sine of z.
	*/
	public static Complex sin(Complex z)
	{
		double x = Math.exp(z.imaginary);
		double x_inv = 1/x;
		double r = Math.sin(z.real) * (x + x_inv)/2;
		double i = Math.cos(z.real) * (x - x_inv)/2;
		return new Complex(r,i);
	}
	/**
	* Calculates the cosine of the <code>Complex</code>
	* @param z the input complex number
	* @return a <code>Complex</code> which is the cosine of z.
	*/
	public static Complex cos(Complex z)
	{
		double x = Math.exp(z.imaginary);
		double x_inv = 1/x;
		double r = Math.cos(z.real) * (x + x_inv)/2;
		double i = -Math.sin(z.real) * (x - x_inv)/2;
		return new Complex(r,i);
	}
	/**
	* Calculates the tangent of the <code>Complex</code>
	* @param z the input complex number
	* @return a <code>Complex</code> which is the tangent of z.
	*/
	public static Complex tan(Complex z)
	{
		return divide(sin(z),cos(z));
	}
	/**
	* Calculates the co-tangent of the <code>Complex</code>
	* @param z the input complex number
	* @return a <code>Complex</code> which is the co-tangent of z.
	*/
	public static Complex cot(Complex z)
	{
		return divide(new Complex(1,0),tan(z));
	}
	/**
	* Calculates the secant of the <code>Complex</code>
	* @param z the input complex number
	* @return a <code>Complex</code> which is the secant of z.
	*/
	public static Complex sec(Complex z)
	{
		return divide(new Complex(1,0),cos(z));
	}
	/**
	* Calculates the co-secant of the <code>Complex</code>
	* @param z the input complex number
	* @return a <code>Complex</code> which is the co-secant of z.
	*/
	public static Complex cosec(Complex z)
	{
		return divide(new Complex(1,0),sin(z));
	}
	/**
	* The real part of <code>Complex</code>
	* @return the real part of the complex number
	*/
	public double getRe()
	{
		return this.real;
	}
	/**
	* The imaginary part of <code>Complex</code>
	* @return the imaginary part of the complex number
	*/
	public double getIm()
	{
		return this.imaginary;
	}
	/**
	* The argument/phase of the current complex number.
	* @return arg(z) - the argument of current complex number
	*/
	public double getArg()
	{
		return Math.atan2(imaginary,real);
	}
	/**
	* Parses the <code>String</code> as a <code>Complex</code> of type x+yi.
	* @param s the input complex number as string
	* @return a <code>Complex</code> which is represented by the string.
	*/
	public static Complex parseComplex(String s)
	{
		s = s.replaceAll(" ","");
		Complex parsed = null;
		if(s.contains(String.valueOf("+")) || (s.contains(String.valueOf("-")) && s.lastIndexOf('-') > 0))
		{
			String re = "";
			String im = "";
			s = s.replaceAll("i","");
			s = s.replaceAll("I","");
			if(s.indexOf('+') > 0)
			{
				re = s.substring(0,s.indexOf('+'));
				im = s.substring(s.indexOf('+')+1,s.length());
				parsed = new Complex(Double.parseDouble(re),Double.parseDouble(im));
			}
			else if(s.lastIndexOf('-') > 0)
			{
				re = s.substring(0,s.lastIndexOf('-'));
				im = s.substring(s.lastIndexOf('-')+1,s.length());
				parsed = new Complex(Double.parseDouble(re),-Double.parseDouble(im));
			}
		}
		else
		{
			// Pure imaginary number
			if(s.endsWith("i") || s.endsWith("I"))
			{
				s = s.replaceAll("i","");
				s = s.replaceAll("I","");
				parsed = new Complex(0, Double.parseDouble(s));
			}
			// Pure real number
			else
			{
				parsed = new Complex(Double.parseDouble(s),0);
			}
		}
		return parsed;
	}
	/**
	* Checks if the passed <code>Complex</code> is equal to the current.
	* @param z the complex number to be checked
	* @return true if they are equal, false otherwise
	*/
	@Override
	public final boolean equals(Object z) 
	{
		if (!(z instanceof Complex))
			return false;
		Complex a = (Complex) z;
		return (real == a.real) && (imaginary == a.imaginary);
	}
	/**
	* The inverse/reciprocal of the complex number.
	* @return the reciprocal of current complex number.
	*/
	public Complex inverse()
	{
		return divide(new Complex(1,0),this);
	}
	/**
	* Formats the Complex number as x+yi or r.cis(theta)
	* @param format_id the format ID <code>Complex.XY</code> or <code>Complex.RCIS</code>.
	* @return a string representation of the complex number
	* @throws IllegalArgumentException if the format_id does not match.
	*/
	public String format(int format_id) throws IllegalArgumentException
	{
		String out = "";
		if(format_id == XY)
			out = toString();
		else if(format_id == RCIS)
		{
			out = mod()+" cis("+getArg()+")";
		}
		else
		{
			throw new IllegalArgumentException("Unknown Complex Number format.");
		}
		return out;
	}
}
