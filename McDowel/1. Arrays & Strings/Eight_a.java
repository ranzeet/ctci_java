class Eight_a {
	public static void main (String[] argr) {
		int[][] matrix = { {4,2,3,4},
				   {2,6,5,6},
				   {1,5,6,9},
				   {9,8,7,0} };

		System.out.println("Original Matrix: \n");
		printMatrix(matrix);
		setZeroes(matrix);
		System.out.println("Zeroed Matrix: \n");
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
	
	static void setZeroes(int [][]mat) {
		boolean row[] = new boolean[mat.length];
		boolean column[] = new boolean[mat[0].length];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		for (int i = 0; i < row.length; i++)
			if (row[i]) nullifyRow(mat, i);
		
		for (int i = 0; i < column.length; i++)
			if (column[i]) nullifyColumn(mat, i);
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
