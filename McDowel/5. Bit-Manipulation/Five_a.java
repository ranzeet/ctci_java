import java.util.Scanner;
class Five_a {
	public static void main(String argr[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number to check if it is a power of 2");
		int n = sc.nextInt();
		System.out.println(((n & (n - 1)) == 0));
	}
}
