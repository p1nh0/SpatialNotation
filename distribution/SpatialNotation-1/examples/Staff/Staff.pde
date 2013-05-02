import spatialnotation.*;

SnAPI api;
SnStaff s; 

void setup() {
	size(600, 600);
	api = new SnAPI(this);
	s = new SnStaff();
	noLoop(); // noLoop() is currently required... 
} 

void draw() {
	s.display(); 
}
