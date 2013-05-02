/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package spatialnotation;
import processing.core.*; 
// REDESIGN THIS CLASS (it isn't working properly yet!)
// the conversion process (from proportional values to pixels) should be redesigned

/**
 * Simple class to draw a note. 
 * 
 * @example Note  
 * 
 *
 */
public class SnNote{
	PApplet P; // the Processing sketch  
	private static final int FILLED =  0, HOLLOW = 1, CROSS = 2;
	private static final int UP = 38, DOWN = 40; // equal to PConstants UP and DOWN
	
	/**
	 * @param head 
	 * 			Note head type.
	 * 			DEFAULT = E_NUM FILLED (0)
	 * 
	 * @param x
	 *          Note head' center X coordinate, in percentage of Size.width (), from 0. to 1. 
	 *          DEFAULT = 0.5 (display window' center)
	 *          
	 * @param y
	 *          Note head' center Y coordinate, in percentage of Size.width (), from 0. to 1. 
	 *          DEFAULT = 0.5 (display window' center)
	 *          
	 * @param width
	 *          Note width, in percentage of Size.width (), from 0. to 1. 
	 *          DEFAULT = 0.2 (display window width)
	 *          
	 * @param height
	 *          Staff height, in percentage of Size.width (), from 0. to 1.          
	 *  		DEFAULT = 0.6 (display window height)
	 *  
	 *  @param weight 
	 *  		Staff line weight, in proportion to the display window height (weight=height/25), from 0. to 1.
	 *  		DEFAULT = 1. (height/25 pixels)
	 *  
	 *  @param color 
	 *  		Staff line color. 
	 *  		DEFAULT = 0 (black)
	 */
	//class properties
	public int head = FILLED; // note head type = filled ellipse 
	public float x=0.5f, y=0.5f; // position = upper left corner  
	public float width = 0.2f, height = 0.6f; // width = 100%, height = 100% 
	public float weight = 1.f; // stroke weight = 100% 
	public int color = 0; // color = black 
	public int direction = DOWN; // direction PConstants: UP(=38) or DOWN(=40)
	
	public SnNote() { // contructor 
		P = SnAPI.getParent(); //get this parent PApplet variable (aka Processing sketch) 
	}
	/**
	 * Draw a note on the display window.
	 * 
	 * @return void
	 */
	public void display(){
		drawNote();
	}
	
	// Drawing methods	
	private void drawNote(){
		drawHead(); 
		drawBeam(x, y, height, weight, direction); 
	}
	
	private void drawHead(){
		switch (head){
		case FILLED:
			ellipticalHead(x, y, width, height, weight, color, FILLED);
		break; 
		
		case HOLLOW:
			ellipticalHead(x, y, width, height, weight, color, HOLLOW);
		break; 
		
		case CROSS: 
			crossHead(x, y, width, height, weight, color);
		break; 
	}
	}
	
	private void crossHead(float theX, float theY, float w, float h, float s,int c){
		  proportionalConvertion(theX, theY, w, h, s);
		  P.pushStyle(); 
		  P.strokeWeight(weight); 
		  P.stroke(c);
		  
		  P.line(x, y, x+width, y+height);
		  P.line(x+width, y, x, y+height);
		  
		  P.popStyle(); 
		
	}
	private void ellipticalHead(float theX, float theY, float w, float h, float s, int c, int type) {
		  proportionalConvertion(theX, theY, w, h, s);
		
		  P.pushStyle();
		  P.pushMatrix();
		  P.strokeWeight(s);
		  P.stroke(c);
		  if (type==FILLED){
			  P.fill(c);
		  } 
		  else {
			P.fill(255, 0);   
		  }
		  
		  P.translate(x, y);
		  P.rotate(-PApplet.QUARTER_PI);
		  P.ellipse(0, 0, w, h);
		  
		  P.popMatrix(); 
		  P.popStyle(); 
	}
	
	private void drawBeam(float theX, float theY, float h, float s, int d) {
		  float w = width*P.width;
		  proportionalConvertion(theX, theY, w, h, s);
		
		  P.pushStyle(); 
		  P.strokeWeight(s);
		  
		  switch (d) {
		    case DOWN : 
		      P.line(x, y, x, y+h);
		      break; 
		    
		    case UP: 
		      P.line(x, y, x, y-h);
		      break; 
		      
		    default: 
		      P.line(x, y, x, y+h); 
		      break;
		  }
		  
		  P.popStyle(); 
	}
	
	
	// Other methods
	private float strokeProportion(float s){
		return (P.height/25.f*s); 
	}
	
	private float widthProportion(float w){
		return (P.width * w);
	}
	private float heightProportion(float h){
		return (P.height * h);
	}
	private void proportionalConvertion(float theX, float theY, float w, float h, float s)
	{
		x = widthProportion(theX); 
		y = heightProportion(theY);
		width = widthProportion(w); 
		height = heightProportion(h);
		weight = strokeProportion(s); 
	}
	
}
