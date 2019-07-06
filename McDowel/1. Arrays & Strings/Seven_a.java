class Seven_a {
	public static void main (String[] argr) {
		int matrix[][] = { {1,2,3,4},
			           {3,4,5,6},
				   {2,7,6,8},
				   {9,0,9,1} };
		System.out.println("Original Matrix: \n");
		printMatrix(matrix);
		if (matrix.length == 0 || matrix[0].length != matrix.length) System.exit(0);
		rotateMatrix(matrix);
		System.out.println("Rotated Matrix: \n");
		printMatrix(matrix);
	}

	static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

	static void rotateMatrix(int[][] mat) {
		int n = mat.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				//Saving top
				int top = mat[first][i];
				//left -> top
				mat[first][i] = mat[last - offset][first];
				//bottom -> left
				mat[last - offset][first] = mat[last][last - offset];
				//right - > bottom 
				mat[last][last - offset] = mat[i][last];
				//top - > right
				mat[i][last] = top;  
			}
		}
	}
}
