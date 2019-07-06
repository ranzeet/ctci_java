class Four_d {
	public static void main (String[] argr) {
		String str = "BA";
		if ( isPermutation(str) )
			System.out.println("It is a permutation");
		else
			System.out.println("Oops! It is not a permutation");
	}
	
	static boolean isPermutation(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}
	
	static int createBitVector(String phrase) {
		int bitVector = 0;
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = bitVector & ~(1 << x) | ~bitVector & (1 << x);
		}
		return bitVector;
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
	
	static boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}
}