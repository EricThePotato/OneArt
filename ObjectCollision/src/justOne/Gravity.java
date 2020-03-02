package justOne;

import java.awt.Graphics;
import java.util.ArrayList;

public class Gravity{
	public void grav(ArrayList<DrawShapes> shapes, Graphics g) {
		for(DrawShapes s: shapes) {
			s.grav(g);
		}		
	}
}
