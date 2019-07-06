class Nine_a {
	public static void main (String[] argr) {
		String s1 = "waterbottle";
		String s2 = "bottlewater";
		if (isRotation(s1, s2))
			System.out.println("Yes string "+s2+" is a rotation of "+s1);
		else
			System.out.println("Nope! string "+s2+" is not a rotation of "+s1);
	}

	static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String s1s1 = s1 + s2;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
	
	static boolean isSubstring(String s1s1, String s2) {
		return s1s1.indexOf(s2) >= 0;
	}
}