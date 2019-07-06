class Seven {
	public static void main (String[] argr) {
		int matrix[][] = { {1,2,3,4},
			           {3,4,5,6},
				   {2,7,6,8},
				   {9,0,9,1} };
		System.out.println("Original Matrix: \n");
		printMatrix(matrix);
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
		for (int i = 0; i < mat.length / 2; i++) {
			int l = mat.length - 1 - i;
			for (int j = i; j < l; j++) {
				int top = mat[i][j];
				mat[i][j] = mat[l - (j - i)][i];
				mat[l - (j - i)][i] = mat[l][l - (j - i)];
				mat[l][l - (j - i)] = mat[j][l];
				mat[j][l] = top;
			}
		}
	}
}