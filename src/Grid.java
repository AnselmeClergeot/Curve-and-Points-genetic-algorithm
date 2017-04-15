import java.util.ArrayList;

public class Grid {
	
	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Solution> solutions = new ArrayList<Solution>();
	
	private int searched_degree, solutions_number;
	
	public Grid()
	{
		
	}
	
	public void setSolutionsNumber(int number)
	{
		this.solutions_number = number;
	}
	
	public void initializeRandomSolutions(double minValue, double maxValue)
	{
		for(int i = 0; i < this.solutions_number; i++)
		{
			this.solutions.add(new Solution(this.searched_degree));
			for(int j = 0; j < this.solutions.get(i).curve().getCoefficientsNumber(); j++)
			{
				this.solutions.get(i).curve().setCoefficient(j, minValue + Math.random() * (maxValue - minValue));
			}
		}
	}
	
	public void calculateFitnesses()
	{
		
	}
	
	public void setCurveDegree(int degree)
	{
		this.searched_degree = degree;
	}
	
	public void addPoint(Point point)
	{
		this.points.add(point);
	}
	
	public void describeSolutions()
	{
		for(Solution sol : this.solutions)
		{
			System.out.println(sol.toString());
		}
	}
}
