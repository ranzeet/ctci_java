/* String concatenation takes O(n^2) time so using String builder*/
class Six_b {
	public static void main (String[] argr) {
		String str = "aaabbcccccaa";
		System.out.println(compressedString(str));
	}

	static String compressedString(String str) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			count++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				sb.append(str.charAt(i));
				sb.append(count);
				count = 0;
			}
		}
		return sb.length() > str.length() ? str : sb.toString();
	}
}