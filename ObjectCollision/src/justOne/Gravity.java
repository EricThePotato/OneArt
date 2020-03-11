package justOne;

import java.awt.Graphics;
import java.util.ArrayList;

public class Gravity{
	public void grav(ArrayList<DrawShapes> shapes, Graphics g) {
		for(DrawShapes s: shapes) {
			s.grav(g);
			for(DrawShapes t: shapes) {
				int x = (int)(Math.abs(s.getX() - t.getX()));
				int y = (int)(Math.abs(s.getY() - t.getY()));
				if(t.getNumber() != s.getNumber() && (int)(Math.sqrt((x*x)+(y*y))) == t.getRadius()+s.getRadius() || (int)(Math.sqrt((x*x)+(y*y)))-1 == t.getRadius()+s.getRadius() || (int)(Math.sqrt((x*x)+(y*y)))+1 == t.getRadius()+s.getRadius()) {
					s.collision(g, y, t.getRadius()+s.getRadius());
				}
			}
		}
		
	}
}
