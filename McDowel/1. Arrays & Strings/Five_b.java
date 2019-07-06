class Five_b {
	public static void main (String[] argr) {
		String str1 = "bal";
		String str2 = "base";
		System.out.println(oneEditAway(str1, str2));
	}
	
	static boolean oneEditAway(String s1, String s2) {
		int s1len = s1.length();
		int s2len = s2.length();
		String st = s1len < s2len ? s1 : s2;
		String lg = s1len < s2len ? s2 : s1;
		boolean foundDiff = false;
		int index1 = 0, index2 = 0;

		while (index1 < st.length() && index2 < lg.length()) {
			if (st.charAt(index1) != lg.charAt(index2)) {
				if (foundDiff)
					return false;
				foundDiff = true;
				if (s1len == s2len)
					index1++;
			} else {
				index1++;
			}
			index2++;
		}
	return true;
	}
}