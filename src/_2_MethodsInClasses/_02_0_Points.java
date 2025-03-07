package _2_MethodsInClasses;

// Superclass (0)
class _02_0_Points {
	
	// fields for coordinates of a point
	double x;
	double y;
	
	// Constructor - assigning values for coordinates 'x' and 'y'
	_02_0_Points(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// Method I - Calculating distance from the centre
	double distance() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
}