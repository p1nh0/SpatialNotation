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

import processing.core.PApplet;

/**
 * You need to instantiate this class before using other classes from spatnot library. 
 * 
 * @example spatnot-Skeleton  
 * 
 *
 */
public class SnAPI{
	static PApplet parent;
	
	/**
	 * You need to pass the variable 'this' to the class constructor 
	 * 
	 * @param parent
	 */
	public SnAPI(PApplet p ){
		parent=p; 
		welcome(); 
	}
	public SnAPI() { // empty constructor for other classes to access???
		
	}
	
	private void welcome() {
		System.out.println("##library.name## ##library.prettyVersion## by ##author##");
	}
	
	public static PApplet getParent(){
		return parent; 
	}
}
