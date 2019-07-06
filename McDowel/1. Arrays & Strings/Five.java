class Five {
	public static void main (String[] argr) {
		String str1 = "pale";
		String str2 = "pleb";
		System.out.println(checkMaxOneEdit(str1, str2));
	}
	static boolean checkMaxOneEdit(String str1, String str2) {
		boolean found = false;
		if (Math.abs(str1.length() - str2.length()) > 1 )
			return false;
		int freq[] = new int[26];
		for (char c : str1.toCharArray())
			freq[c - 'a']++;
		for (char c : str2.toCharArray())
			freq[c - 'a']--;
		for (int val : freq) {
			if (val > 1 || val < -1)
				return false;
			else if (val != 0) {
				if(found)
					return false;
				found = true;
			}	
		}
		return true;
	}
}