public class Main {
	
	public static void main(String[] args)
	{
		Grid grid = new Grid();
		grid.setCurveDegree(2);
		grid.setSolutionsNumber(200);
		grid.initializeRandomSolutions(-10, 10);
		
		//ADDING POINTS
		grid.addPoint(new Point(-16.07097,-16.51801));
		grid.addPoint(new Point(15.63321,34.07978));
		grid.addPoint(new Point(36.9786,6.74339));
		
		for(int i = 0; i < 1000000; i++)
		{
			grid.calculateFitnesses();
			grid.selectParents(2);
			grid.mateParents();
			grid.insertChildren();
			grid.mutateSolutions(0.1, 0.001);
		}
		
		grid.describeSolutions();
	}
	
}
