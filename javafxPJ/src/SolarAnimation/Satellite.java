package SolarAnimation;

import javafx.scene.image.Image;

public class Satellite extends Planet {
	Planet planet;
/**
 * 
 * @param name 
 * @param planet 
 */
	Satellite(String name, Planet planet, Image image, double orbitSpeed, double orbitSize, double planetSize) {
		super(name, image, orbitSpeed, orbitSize, planetSize);
		
		this.planet = planet;
	}

	

	
	@Override
	public double getXPos() {
        //super.getXPos() + planet.getXPos();
		return planet.getXPos() + super.getXPos();
    }
	
	@Override
	public double getYPos() {
		return planet.getYPos() + super.getYPos();
		
    }
}
	

