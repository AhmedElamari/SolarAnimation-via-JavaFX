package SolarAnimation;

import javafx.scene.image.Image;

/**
 * class for simple solar system, initially with sun and earth
 * @author shsmchlr
 *
 */
public class SimpleSolar {
	private double sunSize = 0.2;					// size sun should be drawn
	private double sunX, sunY;						// position of sun
	private double earthSize = 0.05;
	private double earthAngle;						// angle of earth .. for calculating its position
	private double earthOrbitSize = 0.3;			// defines relevant sizes (<1 so that positions in range -0.5 .. +0.5
	private double marsAngle;						// angle of mars
	private double marsOrbitSize = 0.4;			// size of orbit of mars
	private double marsSize = 0.04;
	private Image earth;							// images of earth and sun and mars
	private Image sun;
	private Image mars;

	/**
	 * construct simple solar system
	 */
    public SimpleSolar() {
    	earth = new Image(getClass().getResourceAsStream("earth.png"));		// load image of earth
    	sun = new Image(getClass().getResourceAsStream("sun.png"));
    	mars = new Image(getClass().getResourceAsStream("mars.png"));
    	sunX = 0.5;															// set position of sun
    	sunY = 0.5;
    	earthAngle = 0.0;													// initialise earth
    	marsAngle = 0.0;
    }
    
	/**
	 * update position of planet(s) at specified angle 
	 * @param angle		angle (time dependent) of planet(s)
	 */
	public void updateSystem (double angle) {
		// set angle of earth appropriately
		earthAngle = angle;
		marsAngle = angle/2;
	}
	
	/** 
	 * set sun at position passed
	 * @param x		x position, in canvas coordinates
	 * @param y
	 */
	public void setSystem(MyCanvas mc, double x, double y) {
		// note x,y in range 0.. canvassize
	
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
		mc.drawImage (i, (x+sunX)*cs, (y+sunY)*cs, sz*cs);		// add sun's position to positions then * canvas size
	}
	
	/**
	 * draw system  into specified canvas
	 * @param mc		canvas
	 */
	public void drawSystem (MyCanvas mc) {
		mc.clearCanvas();					// first clear canvas 
		drawImage( mc, sun, 0, 0, sunSize );				// draw sun at 0,0
				// call drawImage to draw earth at position set by earth's angle and orbit size
		drawImage( mc, earth, earthOrbitSize*Math.cos(earthAngle), earthOrbitSize*Math.sin(earthAngle), earthSize );
		drawImage( mc, mars, marsOrbitSize*Math.cos(marsAngle), marsOrbitSize*Math.sin(marsAngle), marsSize );
	}

	/**
	 * return information about planets as a string
	 */
	public String toString() {
	  return "Earth at angle " + earthAngle + "\nMars at angle " + marsAngle;
	  
	  
	}
}
