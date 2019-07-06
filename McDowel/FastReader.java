import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;

import java.util.Scanner;

class FastReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];

	private int curChar;
	private int numChars;

	public FastReader(InputStream stream) {
		this.stream = stream;
	}

	public int scan() throws IOException {
		if (numChars < 0) throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			numChars = stream.read(buf);
			if (numChars <= 0) return -1;
		}
		return buf[curChar++];
	}

	private boolean isWhiteSpace(int n) {
		if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
		return false;
	}

	public int readInt() throws IOException {
		int integer = 0;
		int n = scan();
		while (isWhiteSpace(n)) n = scan();// ignoring leading spaces
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = scan();
		}

		while (!isWhiteSpace(n)) {
			if (n >= '0' && n <= '9') {
				integer *= 10;
				integer += n - '0';
				n = scan();
			} else {
				throw new InputMismatchException();
			}
		}
		return neg * integer;
	}

	public String readString() throws IOException {
		final StringBuilder sb = new StringBuilder();
		int n = scan();
		while (isWhiteSpace(n)) n = scan();

		do {
			sb.append(n);
			n = scan();
		} while (!isWhiteSpace(n));
		return sb.toString();
	}

	public long readLong() throws IOException {
		int n = scan();
		while (isWhiteSpace(n)) n = scan();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = scan();
		}
		long res = 0;
		do {
			res *= 10;
			res += n - '0';
			n = scan();
		} while (!isWhiteSpace(n));

		return neg * res;
	}
 		
	public static void main(String argr[]) throws Exception {
		Scanner s = new Scanner(System.in);
 
		long startTime = System.nanoTime(); //start time

		int n = s.nextInt(); 
		int k = s.nextInt(); 
		int count = 0; 
		while (n-- > 0) 
		{ 
			int x = s.nextInt(); 
			if (x%k == 0) 
			count++; 
		}
	
		long endTime = System.nanoTime();  //end time

 		long timeElapsed = endTime - startTime;
		System.out.println("\n" + count);
		System.out.println("Execution Scanner time in nanoseconds  : " + timeElapsed);
		System.out.println("Execution Scanner time in milliseconds  : " + timeElapsed / 1000000);

		fastRead();	
	}

	public static void fastRead() throws Exception {
		FastReader s = new FastReader(System.in);
		long startTime = System.nanoTime(); //start time

		int n = s.readInt(); 
		int k = s.readInt(); 
		int count = 0; 
		while (n-- > 0) 
		{ 
			int x = s.readInt(); 
			if (x%k == 0) 
			count++; 
		}
	
		long endTime = System.nanoTime();  //end time

 		long timeElapsed = endTime - startTime;
		System.out.println("\n" + count);
		System.out.println("Execution FastReader time in nanoseconds  : " + timeElapsed);
		System.out.println("Execution FastReader time in milliseconds  : " + timeElapsed / 1000000);
	} 
}
