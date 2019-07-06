/*Decimal to Binary*/
class Two_a {
	static String printBinary(double num) {
		if (num >= 1 || num <= 0) return "ERROR!";
		StringBuilder sb = new StringBuilder("0.");
		while (num > 0) {
			if (sb.length() > 32) return "ERROR!";
			double _2n = 2 * num;
			if (_2n >= 1) {
				sb.append("1");
				num = _2n - 1;
			} else {
				sb.append("0");
				num = _2n;
			}
		}
		return sb.toString();
	}
	public static void main(String argr[]) {
		System.out.println(printBinary(0.625));
	}
}
