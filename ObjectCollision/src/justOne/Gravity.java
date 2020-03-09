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
				System.out.println((int)(Math.sqrt((x*x)+(y*y))));
				if(t.getNumber() != s.getNumber() && (int)(Math.sqrt((x*x)+(y*y))) == t.getRadius()+s.getRadius()) {
					System.out.println("cool");
				}
			}
		}
		
	}
}
