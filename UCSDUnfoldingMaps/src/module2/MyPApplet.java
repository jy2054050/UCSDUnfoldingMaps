package module2;

import processing.core.PApplet;
import processing.core.PImage;

public class MyPApplet extends PApplet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String URL= "http://weknowyourdreams.com/images/beach/beach-08.jpg";
	private PImage backgroundImage;
	
	public void setup(){
		
		size(200,200);
		backgroundImage=loadImage(URL,"jpeg");
	}
	
	public void draw(){
		backgroundImage.resize(0, height);
		image(backgroundImage,0,0);
		int color[] = sunColor(second());
		fill(color[0],color[1],color[2]);
		ellipse(width/4, height/5, width/5, height/5);
	
	}

	private int[] sunColor(float second) {
		int[] rgb = new int[3];
		float diffFrom30 =Math.abs(30-second);
		float ratio = diffFrom30/30;
		rgb[0]= (int)(255*ratio);
		rgb[1]= (int)(255*ratio);
		rgb[2]= 0;
		
		return rgb;
	}	
}