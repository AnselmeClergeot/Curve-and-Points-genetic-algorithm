import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CurveDrawing extends JPanel {
	
	private int min_x = 0;
	private int max_x = 10;
	private int min_y = -10;
	private int max_y = 10;
	
	private int border_offset;
	
	private int grid_lines_number;
	
	private int width = 900, height = 700;
	
	private ArrayList<Point> points;
	
	private Curve curve;
	
	public CurveDrawing(int border_offset, int lines_number)
	{
		this.border_offset = border_offset;
		this.grid_lines_number = lines_number;
	}
	
	public void paintComponents(Graphics g)
	{
		//DRAWING THE POINTS
		g.setColor(Color.RED);
		
		for(Point p : this.points)
		{
			g.drawOval(p.getX(), p.getY(), 3, 3);
		}
		
		//DRAWING THE CURVE
		g.setColor(Color.CYAN);
		for(int x = 0; x < this.max_x; x++)
		{
			g.drawRect(this.border_offset + x, this.getScreenYOf(this.curve.getY(x)), 2, 2);
		}
	}
	
	public void drawGrid()
	{
		
	}
	
	public void addPoint(double x, double y)
	{
		if(x < this.min_x)
		this.points.add(new Point(getScreenXOf(x), getScreenYOf(y)));
	}
	
	public void setCurve(Curve curve)
	{
		this.curve = curve;
	}
	
	private int getScreenXOf(double x)
	{
		return (int)((x/(double)this.max_x) * this.width + this.border_offset);
	}
	
	private int getScreenYOf(double y)
	{
		return (int)((y/(double)this.max_y) * this.height + this.border_offset);
	}
	
}
