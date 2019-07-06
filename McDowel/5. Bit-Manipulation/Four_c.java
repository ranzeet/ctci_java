class Four_c {
	static int getNext(int n) {
		int c = n, c0 = 0, c1 = 0;
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) { return -1; }
		int p = c0 + c1;
		return n + (1 << c0) + (1 << (c1 - 1)) - 1;
	}
	static int getPrevious(int n) {
		int temp = n;
		int c0 = 0, c1 = 0;

		while ((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}
		if (temp == 0) return -1;
		while (((temp & 1) == 0) && (temp != 0)) {
			c0++;
			temp >>= 1;
		}
		int p = c0 + c1;
		return n - (1 << c1) - (1 << (c0 - 1)) + 1;	
	}
	public static void main(String argr[]) {
		int n = 13498;
		System.out.println("N is " + n + "\tBinary is " + Integer.toString(n, 2));
		int sol = getNext(n);
		System.out.println("Next number with same no of 1s is " + sol);
		System.out.println("Corresponding Binary is " + Integer.toString(sol, 2));

		int sol1 = getPrevious(n);
		System.out.println("Previous number with same no of 1s is " + sol1);
		System.out.println("Corresponding Binary is " + Integer.toString(sol1, 2));
	}
}
