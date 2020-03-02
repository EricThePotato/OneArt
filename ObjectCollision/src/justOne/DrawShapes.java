package justOne;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawShapes {
	private int radius;
	private int x;
	private int y;
	
	DrawShapes(int xx, int yy, int radiuss){
		x = xx;
		y = yy;
		radius = radiuss;
		
	}
	
	public void drawCircles(Graphics g){
		if(radius % 2 == 0)
			g.setColor(Color.BLACK);
		else
			g.setColor(Color.WHITE);
		g.fillOval(x, y, radius, radius);
	}
	
	public void grav(Graphics g){
		y = y + radius/20;
		drawCircles(g);
	}
}


