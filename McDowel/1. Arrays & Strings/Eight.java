class Eight {
	static int[][] newMat;
	public static void main (String[] argr) {
		int[][] matrix = { {0,2,3,4},
				   {2,6,5,6},
				   {1,5,6,9},
				   {9,8,7,0} };

		System.out.println("Original Matrix: \n");
		printMatrix(matrix);
		zeroMatrix(matrix);
		System.out.println("Rotated Matrix: \n");
		printMatrix(newMat);		
	}

	static void printMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void zeroMatrix(int[][] mat) {
		newMat = copyMatrix(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0)
					doZero(i, j, newMat);
			}
		}
	}
	
	static void doZero(int i, int j, int mat[][]) {
		for (int x = 0; x < mat[i].length; x++) {
			mat[i][x] = 0; 
		}
		
		for (int x = 0; x < mat.length; x++) {
			mat[x][j] = 0;
		}
	}
	
	static int[][] copyMatrix(int[][] mat) {
		int[][] temp = new int[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				temp[i][j] = mat[i][j];
			}
		}
		return temp;
	}
}