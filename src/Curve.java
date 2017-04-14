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
	
}
