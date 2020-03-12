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
				int sqr1 = (int)(Math.sqrt((x*x)+(y*y)));
				int sqr2 = (int)(Math.sqrt((x*x)+(y*y))-1);
				int sqr3 = (int)(Math.sqrt((x*x)+(y*y))+1);
				int totalRadius = t.getRadius()+s.getRadius();
				
				if(t.getNumber() != s.getNumber() && sqr1 == totalRadius || sqr2 == totalRadius || sqr3 == totalRadius) {
					if(s.getY() > t.getY()) {
						s.collision(g, (Math.atan((x/(y+.01))))/(Math.PI/2), t.getRadius()+s.getRadius(), true, true);
						t.collision(g, (Math.atan((y/(x+.01))))/(Math.PI/2), t.getRadius()+s.getRadius(), true, true);
					}
					else {
						t.collision(g, (Math.atan((x/(y+.01))))/(Math.PI/2), t.getRadius()+s.getRadius(), true, true);
						s.collision(g, (Math.atan((y/(x+.01))))/(Math.PI/2), t.getRadius()+s.getRadius(), true, true);
					}
				}
			}
		}
		
	}
}
