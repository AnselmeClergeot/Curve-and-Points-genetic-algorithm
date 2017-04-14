import javax.swing.*;

public class Window extends JFrame {
	
	private CurveDrawing panel;
	
	public Window()
	{
		this.setTitle("Best curves through points : genetic algorithm by Anselme Clergeot");
		this.setSize(900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		
		this.panel = new CurveDrawing(30, 20);
		
		//TESTS
		Curve curve = new Curve(2);
		curve.setCoefficient(0, 2);
		curve.setCoefficient(1, 3);
		this.panel.repaint();
		//
		
		this.setContentPane(this.panel);
		
	}
	
}
