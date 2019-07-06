/*just checking resultant string count befor hand*/
class Six_c {
	public static void main (String[] argr) {
		String str = "Ranjeetttttttttttttttttt";
		if (compressedCount(str) > str.length())
			System.out.println(str);
		else
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
		return sb.toString();
	}
	
	static int compressedCount(String str) {
		int count = 0;
		int solCount = 0; 
		for (int i = 0; i < str.length(); i++) {
			count++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				solCount += 1 + String.valueOf(count).length();
				count = 0;
			}
		}
		return solCount;
	}
}