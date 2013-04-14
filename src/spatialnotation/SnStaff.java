package spatialnotation;
import processing.core.*; 

public class SnStaff{
	PApplet P; // the Processing sketch  
	//DEFAULTS
	float x=0.f, y=0.f; // position = upper left corner  
	float width = 1.f, height = 1.f; // width = 100%, height = 100% 
	float weight = 1.f; // stroke weight = 100% 
	int color = 0; // color = black 
	int lines = 5; // staff type = pentagram 
	
	public SnStaff() {
		P = SnAPI.getParent(); //get this parent PApplet variable (aka Processing sketch) 
	} 
	
	public void display(){
		drawStaff(); 
	}
	
	private void drawStaff() {
		P.pushStyle(); 
		P.strokeCap(PApplet.SQUARE);
		weight = strokeProportion(weight);
		P.strokeWeight(weight);
		// draw staff lines
		for (int i = 0; i<lines; i++) {
			float inc = (height*P.height-weight)/(lines-1)*i + weight/2.f + (y*P.height);
			P.line(x*P.width, inc, width*P.width, inc);
		}
		
		P.popStyle();
	}
	
	public float strokeProportion(float s){
		return (P.height/25.f*s); 
	}
}
