class Seven_a {
	static int swapOddEvenBits(int x) {
		return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) );
	}
	public static void main(String argr[]) {
		int x = 25;
		System.out.println("Swapping odd and even bits in " + x + "\t" + Integer.toString(x,2));
		System.out.println(swapOddEvenBits(x) + "\t\t\t\t\t" + Integer.toString(swapOddEvenBits(x),2));
	}
}
