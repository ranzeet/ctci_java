class Six_a {
	static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c >>= 1) { count += (c & 1); }
		return count;
	}
	public static void main(String argr[]) {
		int a = 29, b = 15;
		System.out.println("a = " + a + "( " + Integer.toString(a,2) + " )" +
			"\tb = " + b + "( " + Integer.toString(b, 2) + " )");
		System.out.println("The required no. of bits to be flipped so as A becomes B is " + bitSwapRequired(a, b));
	}
}
