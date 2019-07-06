class Four_a {
	static int getNext(int n) {
		int c = n, c0 = 0, c1 = 0;
		/*Here I am counting number of trailing zeroes*/
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		/*Now count number of 1s untill we encounter a zero*/
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		/*the next position in 'c' is actually that postion where we flip 0 to 1*/
		/*if it is 11000... 011110000 so error cases*/
		if (c0 + c1 == 31 || c0 + c1 == 0) { return -1; }

		int p = c0 + c1;
		n |= (1 << p); // flipped the bit to 1
		n &= ~((1 << p) - 1); // all digits after p position is zero now
		n |= (1 << (c1 - 1)) - 1;
		return n;
	}
	public static void main(String argr[]) {
		int n = 13498;
		System.out.println("N is " + n + "\tBinary is " + Integer.toString(n, 2));
		int sol = getNext(n);
		System.out.println("Next number with same no of 1s is " + sol);
		System.out.println("Corresponding Binary is " + Integer.toString(sol, 2));
	}
}
