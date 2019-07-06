class Eight_b {
	public static void main (String[] argr) {
		int[][] matrix = { {4,2,3,4},
				   {2,6,5,6},
				   {1,5,6,9},
				   {9,8,7,0} };

		System.out.println("Original Matrix: \n");
		printMatrix(matrix);
		setZeros(matrix);
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

	static void setZeros(int[][] mat) {
		boolean rowHasZero = false;
		boolean colHasZero = false;

		for (int i = 0; i < mat[0].length; i++) {
			if (mat[0][i] == 0) {
				rowHasZero = true;
				break;
			}
		}

		for (int i = 0; i < mat.length; i++) {
			if (mat[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}

		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < mat.length; i++) {
			if (mat[i][0] == 0) nullifyRow(mat, i);
		}
		
		for (int i = 1; i < mat[0].length; i++) {
			if (mat[0][i] == 0) nullifyColumn(mat, i);
		}

		if (rowHasZero) nullifyRow(mat, 0);
		if (colHasZero) nullifyColumn(mat, 0);
	}

	static void nullifyRow(int[][] mat, int row) {
		for (int i = 0; i < mat[row].length; i++)
			mat[row][i] = 0;
	}

	static void nullifyColumn(int[][] mat, int column) {
		for (int i = 0; i < mat.length; i++)
			mat[i][column] = 0;
	}
}