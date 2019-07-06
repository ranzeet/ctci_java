/*Decimal to Binary*/
class Two_b {
	static String printBinary(double num) {
		if (num >= 1 || num <= 0) return "ERROR!";
		StringBuilder sb = new StringBuilder("0.");
		double frac = 0.5;
		while (num > 0) {
			if (sb.length() > 32) return "ERROR!";
			if (num >= frac) {
				sb.append("1");
				num -= frac;
			} else {
				sb.append(0);
			}
			frac /= 2;
		}
		return sb.toString();
	}
	public static void main(String argr[]) {
		System.out.println(printBinary(0.625));
	}
}
