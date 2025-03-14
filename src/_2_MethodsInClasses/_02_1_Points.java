package _2_MethodsInClasses;

import java.util.Scanner;

// Subclass 0.1
class _02_1_Points {

	// Method I (subclass) - Count of all points in an array of objects
	static int pointsCountArray() {
		Scanner scr1 = new Scanner(System.in); // (scanner 1)

		System.out.println("\n" + "---------------------------------------------------");
		System.out.println("How many points are there in the coordinate system?");
		System.out.println("---------------------------------------------------");

		int size; // sizing an array of objects
		
		do { // invalid data for size is checked
			size = scr1.nextInt();
			
			if (size < 3) { // lower bound
				System.out.println("------------------------");
				System.out.println("Invalid data for a size!");
			} else if (size > 50) { // upper limit
				System.out.println("\n" + "-----------------------------------------");
				System.out.println("Too many points in the coordinate system!");
				System.out.println("-----------------------------------------");
			}
		} while (size < 3 || size > 50);
		
		return size; // data for size is returned and then assigned
	}
	
	// Method II (subclass) - Input data for coordinates 'x' and 'y'
	static double pointsCoordinates(String axis) {
		Scanner scr2 = new Scanner(System.in); // (scanner 2)

		System.out.println("------------------------------");
		System.out.printf("Input data for coordinate '%s': %n", axis);
		double coordinate; // it could be either 'x' or 'y'

		do { // size check for coordinate 'x'
			coordinate = scr2.nextDouble();
			
			if (coordinate > 2000 || coordinate < -2000) {
				System.out.println("\n" + "This point is out of the coordinate system!");
				System.out.println("------------------------------------");
				System.out.println("* Coordinates must be up to 2000");
				System.out.println("--------------------------------");
			}
		} while (coordinate > 2000 || coordinate < -2000);

		return coordinate;
	}

	// Main method (starts the program)
	public static void main() {
		// a variable for size of the objects array
		int n = pointsCountArray(); // method I (static from subclass) is called
		
		// array of objects is created, instanced of class "_02_0_Points"
		_02_0_Points[] distances = new _02_0_Points[n];
		
		// data from the objects array is saved in a new array
		double[] pointsDistances = new double[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("\n" + "-------------------");
			System.out.printf("Data for Point [%d]%n", i);
			System.out.println("-------------------");

			// method II (subclass) is called twice
			double x = pointsCoordinates("x");
			double y = pointsCoordinates("y");

			// creating each of the objects in the array of objects
			distances[i] = new _02_0_Points(x, y);

			// assigning a value returned from Method I (from the superclass)
			pointsDistances[i] = distances[i].distance();
		}

		// an array of integers saving indexes of the pointsDistances with minimal distance between them
		int[] minPoints = new int[2];

		// first value is set to the variable (could be changed below)
		double minDistanceDiff = Math.abs(pointsDistances[1] - pointsDistances[0]);

		// first values are set to the numbers (indexes) of needed pointsDistances
		minPoints[1] = 1; // minPoints[0] = 0 is redundant (assigned this value by default)

		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// assigning current value for difference in distances
				double currentDiff = Math.abs(pointsDistances[i] - pointsDistances[j]);

				if (currentDiff < minDistanceDiff) {
					// new value for minimal distance is set
					minDistanceDiff = currentDiff;

					// indexes of the pair of points are marked
					minPoints[0] = i;
					minPoints[1] = j;
				}
			}
		}

		System.out.printf("\n" + "-> Points with the smallest distance between them are " +
				"point [%d] and point [%d].%n", minPoints[0], minPoints[1]);

		System.out.println("----------------------------------");
		System.out.printf("Distance of %.2f measurement units%n", minDistanceDiff);
		System.out.println("----------------------------------");
	}
}