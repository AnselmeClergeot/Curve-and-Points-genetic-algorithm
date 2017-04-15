
public class Solution {
	
	private double fitness;
	private Curve curve;
	
	public Solution(int degree)
	{
		this.curve = new Curve(degree);
		this.fitness = 0;
	}
	
	public double getFitness()
	{
		return this.fitness;
	}
	
	public void setFitness(double fitness)
	{
		this.fitness = fitness;
	}
	
	public Curve curve()
	{
		return this.curve;
	}
	
	public String toString()
	{
		return new String("Fitness : " + this.fitness + ". Equation : " + this.curve.toString());
	}
}
