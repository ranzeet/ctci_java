/*Egg Drop Problem*/
class Nine_a {
	static int breakPoint = 99;
	static int countDrops = 0;

	static boolean drop(int floor) {
		countDrops++;
		return floor >= breakPoint;
	}

	static int findBreakPoint(int floors) {
		int interval = 14;
		int previousFloor = 0;
		int egg1 = interval;

		while (!drop(egg1) && egg1 <= floors) {
			interval -= 1;
			previousFloor = egg1;
			System.out.println("Dropping egg1 from floor " + egg1);
			egg1 += interval;
		}
		int egg2 = previousFloor + 1;
			System.out.println();
		while (egg2 < egg1 && egg2 <= floors && !drop(egg2)) {
			System.out.println("Dropping egg2 from floor: " + egg2);
			egg2 += 1;
		}
		return egg2 > floors ? -1 : egg2;
	}

	public static void main(String argr[]) {
		int floors = 100;
		System.out.println("Broke point : " + findBreakPoint(floors));
	}
}
