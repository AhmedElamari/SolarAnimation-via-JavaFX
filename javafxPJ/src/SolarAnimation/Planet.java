package SolarAnimation;

import javafx.scene.image.Image;

public class Planet {

protected String name;
protected Image image;
protected double orbitSpeed;
protected double orbitSize;
protected double planetAngle;
protected double planetSize;



Planet(){
	this("planet", new Image("image.png"), 0, 0, 0);
}

Planet(String name, Image image, double orbitSpeed, double orbitSize, double planetSize) {
this.name = name;
this.image = image;
this.orbitSpeed = orbitSpeed;
this.orbitSize = orbitSize;
this.planetSize = planetSize;

}




  

public void updatePosition(double tAng) {
	//set planet angle based on tAng and planet's spee
	 
	planetAngle = tAng * orbitSpeed;
}

public double getXPos() {
	//use orbit sie and angle
	return orbitSize * Math.cos(planetAngle);
	
	
}
public double getYPos() {
	return orbitSize * Math.sin(planetAngle);
	
}
public void drawPlanet(SolarSystem s, MyCanvas mc) {
	s.drawImage(mc, image, getXPos(), getYPos(), planetSize);
	s.toString();
}

public String toString(double tAngle) {
    return name + " at angle " +  planetAngle;
}
}

