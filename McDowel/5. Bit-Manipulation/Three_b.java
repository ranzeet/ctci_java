/*LOL this is so simple though the former was tough*/
class Three_b {
	static int flipBit(int a) {
		if (~a == 0) return Integer.BYTES * 8;
		
		int maxLength = Integer.MIN_VALUE;
		int curLen = 0, prevLen = 0;
		while (a != 0) {
			if ((a & 1) == 1) {
				curLen++;
			} else if ((a & 1) == 0) {
				prevLen = (a & 2) == 0 ? 0 : curLen;
				curLen = 0;
			}
			maxLength = Math.max(1 + prevLen + curLen, maxLength);
			a >>>= 1;
		}
		return maxLength;
	}
	public static void main(String argr[]) {
		int n = 1775;
		System.out.println("n : " + n + " in binary " + Integer.toString(n, 2));
		System.out.println(flipBit(n));
	}
}
