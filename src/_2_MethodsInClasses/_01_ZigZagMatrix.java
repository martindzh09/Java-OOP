package _2_MethodsInClasses;

import java.util.Scanner;

public class _01_ZigZagMatrix {
	// saving data for matrix size (both rows and columns)
	int n; // field 1

	// definition of two-dimensional array (matrix)
	int[][] matrix = new int[n][n]; // sized to 'n'
	// field 2 (above)

	// Method I - Data for size of the quadratic matrix
	public int matrixSizing() {
		Scanner scr1 = new Scanner(System.in); // (scanner 1)

		System.out.println("\n" + "----------------");
		System.out.println("I. Matrix sizing");
		System.out.println("----------------");

		System.out.println("\n" + "How many rows and columns the matrix is consisted of?");
		System.out.println("-----------------------------------------------------");
		int n; // size for both rows and columns of the matrix (2D array)

		do { // check for an invalid input
			n = scr1.nextInt();

			if (n <= 0) { // a message for invalidation is printed
				System.out.println("Incorrect value!");
			}
		} while (n <= 0);

		return n; // value of the variable for matrix size is returned
	}

	// Method II - Data for elements in the matrix
	public int[][] matrixData(int n) {
		Scanner scr2 = new Scanner(System.in); // (scanner 2)

		// two-dimensional array is sized to 'n' (matrix)
		int[][] matrix = new int[n][n];

		System.out.println("\n" + "-----------------------------");
		System.out.println("II. Data for matrix' elements");
		System.out.println("-----------------------------");

		for (int i = 0; i < n; i++) { // rows (i)
			for (int j = 0; j < n; j++) { // columns (j)
				System.out.printf("\n" + "Input data for element [%d][%d]: %n", i, j);
				matrix[i][j] = scr2.nextInt();
			}
		}

		// data for matrix is printed
		System.out.println("\n" + "________________");
		System.out.println("Original matrix:");

		for (int i = 0; i < n; i++) { // rows (i)
			for (int j = 0; j < n; j++) { // columns (j)
				if (j == (n - 1)) { // last element on the row
					System.out.printf("| %d |", matrix[i][j]);
				}
				else {
					System.out.printf("| %d ", matrix[i][j]);
				}
			}
			System.out.println(); // next line when whole row is printed
		}

		return matrix; // data for matrix is returned
	}

	// Method III - Zig-zag matrix
	public void zigZagPrint(int[][] matrix) {
		// changed (zigzag) matrix is saved as a different 2D array
		int[][] zigZagMatrix = new int[matrix.length][matrix.length];

		for (int i = 0; i < matrix.length; i++) { // rows (i)
			// reversed iterating variable for assigning values from the opposite side
			int j1 = matrix.length - 1;

			for (int j = 0; j < matrix.length; j++) { // columns (j)
				// when an odd* row is marked (* even row if mathematically counted)
				if (!(i % 2 == 0)) {
					zigZagMatrix[i][j1] = matrix[i][j];
					j1--; // position decreases as 'j' increases through each iteration
				}
				else { // data for row is unchanged (automatically copied to the new matrix)
					zigZagMatrix[i][j] = matrix[i][j];
				}
			}
		}

		// printing changed matrix ("zigzag" formatted)
		System.out.println("\n" + "_______________");
		System.out.println("Zig-Zag Matrix:");

		for (int i = 0; i < zigZagMatrix.length; i++) {
			for (int j = 0; j < zigZagMatrix.length; j++) {
				if (j == (zigZagMatrix.length - 1)) { // last element on the row
					if (!(i % 2 == 0)) { // indicating changed rows
						System.out.printf("| %d | <--", zigZagMatrix[i][j]);
					} else {
						System.out.printf("| %d |", zigZagMatrix[i][j]);
					}
				}
				else {
					System.out.printf("| %d ", zigZagMatrix[i][j]);
				}
			}
			System.out.println(); // next line when whole row is printed
		}
	}
}