import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Grid {
	
	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Solution> solutions = new ArrayList<Solution>();
	
	private ArrayList<Solution> parents = new ArrayList<Solution>();
	private ArrayList<Solution> children = new ArrayList<Solution>();
	
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
		for(Solution sol : this.solutions)
		{
			sol.setFitness(this.getFitnessOf(sol.curve()));
		}
		
		this.solutions.sort(Collections.reverseOrder(Comparator.comparing(Solution::getFitness)));
	}
	
	public void selectParents(int numberOfParents)
	{
		double sumOfFitnesses = 0;
		
		for(Solution sol : this.solutions)
		{
			sumOfFitnesses += sol.getFitness();
		}
		
		for(int i = 0; i < numberOfParents; i++)
		{
			double selectedFitness = Math.random() * sumOfFitnesses;
			int selectedSolution = 0;
			
			double currentFitness = this.solutions.get(0).getFitness();
			
			while(currentFitness < selectedFitness)
			{
				currentFitness += this.solutions.get(selectedSolution).getFitness();
				selectedSolution++;
			}
			this.parents.add(this.solutions.get(selectedSolution));
		}
	}
	
	public void mateParents()
	{
		for(int i = 0; i < this.parents.size(); i++)
		{
			for(int j = i+1; j < this.parents.size(); j++)
			{
				ArrayList<Solution> children = Crossovers.uniformCrossover(this.solutions.get(i), this.solutions.get(j));
				
				for(Solution s : children)
				{
					this.children.add(s);
				}
			}
		}
		
		this.parents.clear();
	}
	
	public void insertChildren()
	{
		for(int i = 0; i < this.children.size(); i++)
		{
			this.solutions.set(this.solutions_number-1-i, this.children.get(i));
		}
		
		this.children.clear();
	}
	
	public void mutateSolutions(double probability, double coefficientVariation)
	{
		for(Solution sol : this.solutions)
		{
			for(int i = 0; i < sol.curve().getCoefficientsNumber(); i++)
			{
				if(Math.random() < probability)
				{
					sol.curve().setCoefficient(i, sol.curve().getCoefficient(i) + (Math.random() - 0.5)/10);
				}
			}
		}
	}
	
	private double getFitnessOf(Curve curve)
	{
		double cumulative_error = 0;
		
		for(Point point : this.points)
		{
			cumulative_error += curve.getErrorOfY(point.getX(), point.getY());
		}
		
		return (1/cumulative_error)*10000;
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
