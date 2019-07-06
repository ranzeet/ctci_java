class Five_a {
	public static void main (String[] argr) {
		String str1 = "aple";
		String str2 = "apple";
		System.out.println(oneEditAway(str1, str2));
	}
	
	static boolean oneEditAway(String s1, String s2) {
		if (Math.abs(s1.length() - s2.length()) > 1)
			return false;
		if (s1.length() == s2.length())
			return oneEditReplace(s1, s2);
		if (s1.length() == s2.length() + 1)
			return oneEditInsert(s2, s1);
		if (s1.length() + 1 == s2.length())
			return oneEditInsert(s1, s2);
		return false;
	}
	
	static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference)
					return false;
				foundDifference = true;
			}
		}
		return true;
	}

	static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
			
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s2.charAt(index2) != s1.charAt(index1)) {
				if (index2 != index1)
					return false;
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}
}