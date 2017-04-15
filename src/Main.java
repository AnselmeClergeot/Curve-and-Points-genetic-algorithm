public class Main {
	
	public static void main(String[] args)
	{
		Grid grid = new Grid();
		grid.setCurveDegree(2);
		grid.setSolutionsNumber(15);
		
		grid.initializeRandomSolutions(-200, 200);
		
		grid.describeSolutions();
	}
	
}
