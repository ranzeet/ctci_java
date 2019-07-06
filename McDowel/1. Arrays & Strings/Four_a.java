class Four_a {
	public static void main (String argr[]) {
		String str = "tactcoa";
		if ( isPallindrome(str) )
			System.out.println("It is a pallindrome :" + str);
		else
			System.out.println("It is not pallindrome :" + str);
	}

	static boolean isPallindrome( String phrase ) {
		int[] table = buildCharFreqTable( phrase );
		return checkMaxOneOdd( table );
	}

	static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for ( int count : table ) {	
			if ( count % 2 == 1) {
				if ( foundOdd ) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
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

	static int[] buildCharFreqTable( String phrase ) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for ( char ch : phrase.toCharArray() ) {
			int x = getCharNumber(ch);
			if ( x != -1 )
				table[x]++;
		}
		return table;
	}
}