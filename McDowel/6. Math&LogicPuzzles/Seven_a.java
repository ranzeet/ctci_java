/*Blue eyed Island puzzzzzzzzzzzzzzzzle*/
import java.util.Random;
class Seven_a {
	static double runFamilies(int n) {
		int boys = 0, girls = 0;
		for (int i = 0; i < n; i++) {
			int [] gender = runOneFamily();
			boys += gender[0];
			girls += gender[1];
		}
		return girls / (double) (boys + girls);
	}
	static int[] runOneFamily() {
		int boys = 0, girl = 0;
		Random random = new Random();
		while (girl == 0) {
			if (random.nextBoolean()) {
				girl += 1;
			} else {
				boys += 1;
			}
		}
		return new int[] {boys, girl};
	}
	public static void main(String argr[]) {
		int n = 100;
		System.out.println("Gender ratio on the island for n = " + n + " is " + runFamilies(n));
	}
}
