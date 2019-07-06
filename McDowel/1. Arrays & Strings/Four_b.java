import java.util.Arrays;
class Four_b {
	public static void main (String argr[]) {
		String str = "cacxcac";
		if ( isPallindrome(str) )
			System.out.println("It is a pallindrome :" + str);
		else
			System.out.println("It is not pallindrome :" + str);
	}

	static boolean isPallindrome( String phrase ) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for ( char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			if ( x != -1 ) {
				table[x]++;
				if ( table[x] % 2 == 1 ) {
					countOdd++;	System.out.println("\nIf>>char "+c+" table[x] = "+table[x]+" countOdd = "+countOdd+"\n"+Arrays.toString(table)+"\n");
				} else {
					countOdd--;	System.out.println("\nElse>>char "+c+" table[x] = "+table[x]+" countOdd = "+countOdd+"\n"+Arrays.toString(table)+"\n");
				}
			}
		}
	return countOdd <= 1;		
	}

	static int getCharNumber( char ch ) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(ch);
		if ( a <= val && val <= z )
			return val - a;
		else
			return -1;
	}
}