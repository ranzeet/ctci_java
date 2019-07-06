import java.util.ArrayList;
class Three_a {
	static int getLongestSequence(ArrayList<Integer> seq) {
		int maxSeq = Integer.MIN_VALUE;
		for (int i = 0; i < seq.size(); i += 2){
			int zeroSeq = seq.get(i);
			int onesRightSeq = (i - 1) >= 0 ? seq.get(i - 1) : 0;
			int onesLeftSeq = (i + 1) < seq.size() ? seq.get(i + 1) : 0;

			int thisSeq = 0;
			if (zeroSeq == 1) {
				thisSeq = 1 + onesLeftSeq + onesRightSeq;
			} else if (zeroSeq > 1) {
				thisSeq = 1 + Math.max(onesLeftSeq, onesRightSeq);
			} else if (zeroSeq == 0) {
				thisSeq = Math.max(onesLeftSeq, onesRightSeq);
			}
			maxSeq = Math.max(maxSeq, thisSeq);
		}
		return maxSeq;
	}
	static ArrayList<Integer> getAlternatingSequence(int n) {
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		int searchFor = 0, counter = 0;
		for (int i = 0; i < Integer.SIZE; i++) {
			if ((n & 1) != searchFor) {
				sequence.add(counter);
				searchFor = n & 1;
				counter = 0;
			}
			counter++;
			n >>>= 1;
		}
		sequence.add(counter);
		return sequence;
	}
	static int longestSequence(int n) {
		if (n == -1) return Integer.BYTES * 8;
		ArrayList<Integer> sequence = getAlternatingSequence(n);
		return getLongestSequence(sequence);
	}
	public static void main(String argr[]) {
		int n = 1775;
		System.out.println("n : " + n + " in binary " + Integer.toString(n, 2));
		System.out.println(longestSequence(n));
	}
}	
