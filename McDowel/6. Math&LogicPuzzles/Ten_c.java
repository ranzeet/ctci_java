import java.util.*;
class Ten_c extends Ten_a {
	int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
		runTests(bottles, strips);
		ArrayList<Integer> positive = getPositiveOnDay(strips, 7);
		return setBits(positive);
	}
	void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips) {
		for (Bottle bottle : bottles) {
			int id = bottle.getId();
			int bitIndex = 0;
			while (id > 0) {
				if ((id & 1) == 1) {
					testStrips.get(bitIndex).addDropOnDay(0, bottle);
				}
				bitIndex++;
				id >>= 1;  
			}
		}
	}

	ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> testStrips, int day) {
		ArrayList<Integer> positive = new ArrayList<Integer>();
		for (TestStrip testStrip : testStrips) {
			int id = testStrip.getId();
			if (testStrip.isPositiveOnDay(day)) {
				positive.add(id);
			}
		}
		return positive;
	}

	int setBits(ArrayList<Integer> positive) {
		int id = 0;
		for (Integer bitIndex : positive) {
			id |= 1 << bitIndex;
		}
		return id;
	}

	public static void main(String argr[]) {
		Ten_c obj = new Ten_c();
		ArrayList<Bottle> bottles = new ArrayList<Bottle>();
		for (int i = 0; i < 1000; i++) {
			Bottle bottle = new Bottle(i);
			bottles.add(bottle);
		}
		bottles.get(786).setAsPoisoned();

		ArrayList<TestStrip> ts = new ArrayList<TestStrip>();
		for (int i = 0; i < 10; i++) {
			TestStrip tsp = new TestStrip(i);
			ts.add(tsp);
		}
		System.out.println(obj.findPoisonedBottle(bottles, ts));
	}
}
