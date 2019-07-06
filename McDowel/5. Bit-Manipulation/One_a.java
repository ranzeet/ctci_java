/*(insertion) N = 1 0000 0000 00, M = 10011, i = 2, j = 6.... O/P: 10001001100 */
class One_a {
	public static void main(String argr[]) {
		int N = 0b10000000000;
		int M = 0b10011;
		int i = 2, j = 6;

		int l = ~0 << (j + 1); // 111_0000_000
		int r = (1 << i) - 1;

		int mask = l | r;
		int n_cleared = N & mask;
		int m_shifted = M << i;
		int sol = n_cleared | m_shifted;
		System.out.println(Integer.toString(sol, 2));		
	}
}
