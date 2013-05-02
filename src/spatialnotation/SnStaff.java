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

/**
 * Simple class to draw a staff. 
 * 
 * @example Staff  
 * 
 *
 */
public class SnStaff{
	PApplet P; // the Processing sketch  
	//DEFAULTS
	/**
	 * @param lines 
	 * 			Number of lines in staff.
	 * 			DEFAULT = 5 (pentagram)
	 * 
	 * @param x
	 *          Staff top-left corner X coordinate, in percentage of Size.width (), from 0. to 1. 
	 *          DEFAULT = 0. (display window top-left corner)
	 *          
	 * @param y
	 *          Staff top-left corner Y coordinate, in percentage of Size.width (), from 0. to 1.
	 *          DEFAULT = 0. (display window top-left corner)
	 *          
	 * @param width
	 *          Staff width, in percentage of Size.width (), from 0. to 1. 
	 *          DEFAULT = 1. (display window width)
	 *          
	 * @param height
	 *          Staff height, in percentage of Size.width (), from 0. to 1.          
	 *  		DEFAULT = 1. (display window height)
	 *  
	 *  @param weight 
	 *  		Staff line weight, in proportion to the display window height (weight=height/25), from 0. to 1.
	 *  		DEFAULT = 1. (height/25 pixels)
	 *  
	 *  @param color 
	 *  		Staff line color. 
	 *  		DEFAULT = 0 (black)
	 */
	public int lines = 5; // staff type = pentagram 
	public float x=0.f, y=0.f; // position = upper left corner  
	public float width = 1.f, height = 1.f; // width = 100%, height = 100% 
	public float weight = 1.f; // stroke weight = 100% 
	public int color = 0; // color = black 
	
	public SnStaff() {
		P = SnAPI.getParent(); //get this parent PApplet variable (aka Processing sketch) 
	} 
	/**
	 * Draw staff on display window.
	 * 
	 * @return void
	 */
	
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
	
	private float strokeProportion(float s){
		return (P.height/25.f*s); 
	}
}
