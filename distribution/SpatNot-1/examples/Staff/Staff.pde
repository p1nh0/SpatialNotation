import spatnot.library.*;

SpatnotAPI api;
SnStaff s; 

void setup() {
	size(600, 600);
	api = new SpatnotAPI(this);
	s = new SnStaff(); 
} 

void draw() {
	s.display(); 
}