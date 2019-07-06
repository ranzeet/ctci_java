class Six_a {
	public static void main (String[] argr) {
		String str = "aabcccccaaa";
		System.out.println(compressBad(str));
	}
	
	static String compressBad(String str) {
		String sol = "";
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				sol += "" + str.charAt(i) + count;
				count = 0;
			}
		}
		return sol;
	}
}