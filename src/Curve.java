public class Curve {
	
	private int degree;
	private double[] coefficients;
	
	public Curve(int degree)
	{
		this.degree = degree;
		this.coefficients = new double[degree + 1];
	}
	
	public void setCoefficient(int coefficient, double value)
	{
		this.coefficients[coefficient] = value;
	}
	
	public double getCoefficient(int coefficient)
	{
		return this.coefficients[coefficient];
	}
	
	public int getCoefficientsNumber()
	{
		return this.coefficients.length;
	}
	
	public int getDegree()
	{
		return this.degree;
	}
	
	public double getY(double x)
	{
		double y = 0;
		
		for(int i = 0; i < this.degree + 1; i++)
		{
			if(i == this.degree) //If it is the real number without x attached
			{
				y += this.coefficients[this.degree];
			}
			else
			{
				y += this.coefficients[i] * Math.pow(x, this.degree - i);
			}
		}
		
		return y;
	}
	
	public double getErrorOfY(double x, double y)
	{
		return Math.abs(getY(x) - y);
	}
	
	public String toString()
	{
		String res = "y = ";
		
		for(int i = 0; i < this.coefficients.length; i++)
		{
			if(this.coefficients[i] > 0 && i != 0)
				res += " + ";
			else
				res += " ";
			
			res += this.coefficients[i];
			
			if(i != this.coefficients.length - 1)
			{
				if(i != this.coefficients.length - 2)
					res += "x^" + (this.degree-i);
				else
					res+= "x";
			}
				
		}
		
		return res;
	}
	
}
