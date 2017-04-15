public class Main {
	
	public static void main(String[] args)
	{
		Grid grid = new Grid();
		grid.setCurveDegree(2);
		grid.setSolutionsNumber(100);
		grid.initializeRandomSolutions(-10, 10);
		
		//ADDING POINTS
		grid.addPoint(new Point(-3, 9));
		grid.addPoint(new Point(-2, 4));
		grid.addPoint(new Point(-1, 1));
		
		for(int i = 0; i < 100000; i++)
		{
			grid.calculateFitnesses();
			grid.selectParents(3);
			grid.mateParents();
			grid.insertChildren();
			grid.mutateSolutions(0.05, 0.001);
		}
		
		grid.describeSolutions();
	}
	
}
