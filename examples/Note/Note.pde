import spatialnotation.*;

SnAPI api;
SnNote n; 

void setup() {
	size(600, 600);
	api = new SnAPI(this);
	n = new SnNote();
	noLoop(); // noLoop() is currently required... 
} 

void draw() {
	n.display(); 
}