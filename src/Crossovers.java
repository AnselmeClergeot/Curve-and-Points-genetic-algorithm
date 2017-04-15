import java.util.ArrayList;

public class Crossovers {

	public static ArrayList<Solution> uniformCrossover(Solution lhs, Solution rhs)
	{
		ArrayList<Solution> children = new ArrayList<Solution>();
		
		for(int i = 0; i < 2; i++)
			children.add(new Solution(lhs.curve().getDegree()));
		
		for(int i = 0; i < lhs.curve().getCoefficientsNumber(); i++)
		{
			int parentSelected = (int)Math.random();
			
			if(parentSelected == 0)
			{
				children.get(0).curve().setCoefficient(i, lhs.curve().getCoefficient(i));
				children.get(1).curve().setCoefficient(i, rhs.curve().getCoefficient(i));
			}
			else
			{
				children.get(0).curve().setCoefficient(i, rhs.curve().getCoefficient(i));
				children.get(1).curve().setCoefficient(i, lhs.curve().getCoefficient(i));
			}
		}
		
		return children;
	}
	
}
