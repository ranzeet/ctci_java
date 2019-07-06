class Four_b {
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
		n &= ((~0) << (p + 1));
		int mask = (1 << (c1 +1)) - 1; // sequwnce of c1 +1 ones
		n |= mask << (c0 - 1);
		return n;	
	}
	public static void main(String argr[]) {
		int n = 21;
		System.out.println("N is " + n + "\tBinary is " + Integer.toString(n, 2));
		int sol = getPrevious(n);
		System.out.println("Previous number with same no of 1s is " + sol);
		System.out.println("Corresponding Binary is " + Integer.toString(sol, 2));
	}
}
