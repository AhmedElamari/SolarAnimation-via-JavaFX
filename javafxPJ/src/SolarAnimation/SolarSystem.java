/**
 * 
 */
package SolarAnimation;

import java.util.ArrayList;

import javafx.scene.image.Image;

/**
 * @author shsmchlr
 *
 */
public class SolarSystem {
	private double sunX, sunY, sunSize;				// positions of sun
    private Image sun;								// imnge of sun
  private Planet Earth;
  private Planet Mars;
  private Satellite Moon;
    

//    private Planet Earth;
    
    /**
     * constructor for setting up solar system
     */
	public SolarSystem() {   
	
	    sun = new Image(getClass().getResourceAsStream("sun.png"));
	    sunX = 0.5;
	    sunY = 0.5;
	    sunSize = 0.2;
	    Earth = new Planet("Earth", new Image(getClass().getResourceAsStream("earth.png")), 1, 0.3, 0.05);
	    Mars = new Planet("Mars", new Image(getClass().getResourceAsStream("mars.png")), 0.5, 0.4, 0.04);
	      Moon = new Satellite("Moon", Earth, new Image(getClass().getResourceAsStream("moon.png")), 1, 0.05, 0.02);
	   
	    
	}

	/**
	 * Calculate the position of each object in system
	 * @param angle	indication of time/angle
	 */
	public void updateSystem (double angle) {
		Earth.updatePosition(angle);
		Mars.updatePosition(angle);
		Moon.updatePosition(angle);
		
	} 
	
	/**
	 * draw the system into the given viewer
	 * @param s
	 */
	public void drawSystem(MyCanvas mc) {
		mc.clearCanvas();								// clear canvas
		drawImage(mc, sun, 0, 0, sunSize);			// draw Sun,
		Earth.drawPlanet(this, mc);
		Mars.drawPlanet(this, mc);
		Moon.drawPlanet(this, mc);
	
		
	}
	
	/**
	 * drawImage into canvas, at position x,y relative to sun, but scale the x,y and sz before drawing
	 * @param mc	canvas
	 * @param i		image
	 * @param x		x position		in range -0.5..0.5
	 * @param y		y position
	 * @param sz	size
	 */
	public void drawImage (MyCanvas mc, Image i, double x, double y, double sz) {
		int cs = mc.getXCanvasSize();
		mc.drawImage (i, (x+sunX)*cs, (y+sunY)*cs, sz*cs);		// add 0.5 to positions then * canvas size
	}

	/**
	 * return String with info of planet(s) in system
	 */
	public String toString() {
		return Earth.toString() + "\n" + Mars.toString() + "\n" + Moon.toString();
		
		
		
	}

}
