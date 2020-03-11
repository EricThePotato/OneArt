package justOne;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import java.util.ArrayList;

//
public class Window extends JFrame{
	
  static final int FPS = 60;
  
  int timer = 0;
  
  ArrayList<DrawShapes> shapes = new ArrayList<DrawShapes>();
  
  Gravity gravity = new Gravity();
    
  Canvas canvas = new Canvas();
  
  public static void main(String[] args) {
    new Window();
  }
  
  Window() {
	
	// When the close button is clicked, the program terminates
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // Size of the window
    setSize(800, 450);
    // Set the position to the center of the screen
    setLocationRelativeTo(null);
    // Title of the window
    setTitle("Art");
    
    // Add the canvas to the frame (for graphics)
    add(canvas);
    // Make the frame visible
    setVisible(true);
    
    // Create a buffer strategy for the canvas to get buffered rendering. 3 buffers.
    canvas.createBufferStrategy(2);
    
    // Start the game loop
    startGameLoop();
    
    
  }
  
  // Runs the update and render methods FPS times per second
  void startGameLoop() {
    long now = System.nanoTime(), lastLoop = now, loopTime = 1000000000 / FPS;
    while (true) {
      if ((now = System.nanoTime()) - lastLoop > loopTime) {
    	update();
        render();
        lastLoop = now;
      }
    }
  }
  
  void update() {
	  timer ++;
	
	  
  }
  
  public void render() {
	BufferStrategy bs = canvas.getBufferStrategy();
    Graphics g = bs.getDrawGraphics();
    // This is where the drawing occurs
    g.setColor(Color.GRAY);
    g.fillRect(0, 0, getContentPane().getWidth(), getContentPane().getHeight());
    if(timer % 30 == 0) {
    	DrawShapes shape = new DrawShapes((int)(Math.random()*801), (int)(Math.random()*100), (int)(Math.random()*51)+1, getContentPane().getHeight());
        shapes.add(shape); 
    }
    
    
    gravity.grav(shapes, g);
    g.dispose();
    bs.show();
  }
  
  
}