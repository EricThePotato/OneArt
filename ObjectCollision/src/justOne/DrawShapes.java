package justOne;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawShapes {
	private int radius;
	private int x;
	private int y;
	private double v;
	static int height;
	
	DrawShapes(int xx, int yy, int radiuss, int h){
		x = xx;
		y = yy;
		radius = radiuss;
		height = h;
	}
	
	public void drawCircles(Graphics g){
		if(radius % 2 == 0)
			g.setColor(Color.BLACK);
		else
			g.setColor(Color.WHITE);
		g.fillOval(x, y, radius, radius);
	}
	
	public void grav(Graphics g){
		v += .2;
		y += v;
		
		if(y + radius >= height)		
			v = -v;
		
		drawCircles(g);
	}
}


