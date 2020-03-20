package justOne;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawShapes {
	private int radius;
	private int x;
	private int y;
	private double vy;
	private double vx;
	static int height;
	static int width;
	static int counter;
	private int number;
	private int[] col = {(int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)};
	
	DrawShapes(int xx, int yy, int radiuss, int h, int w){
		x = xx;
		y = yy;
		radius = radiuss;
		height = h;
		width = w;
		counter++;
		number = counter;
	}
	
	public void drawCircles(Graphics g){
		g.setColor(new Color(col[0], col[1], col[2]));
		g.fillOval(x, y, radius, radius);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, radius, radius);
	}
	
	public void grav(Graphics g){
		if(x + radius < width || x - radius > 0) {
			vy += .2;
			y += vy;
		}
		if(y + radius > height)
			y = height-radius;
		
		if(y + radius >= height)		
			vy = -0.75*vy + 1.2;
		x += vx;
		drawCircles(g);
	}
	
	public void collision(Graphics g, double d, int total, boolean right, boolean up) {
		vy -= 5 * d;
		vx = 5 * 1-d;
		y += vy;
		x += vx;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public int getNumber() {
		return number;
	}
}


