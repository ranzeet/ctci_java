/*POISON PUZZLE*/
import java.util.*;
class Ten_a {
	int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
		int today = 0;
		while (bottles.size() > 1 && strips.size() > 0) {
			runTestSet(bottles, strips, today);
			today += TestStrip.DAYS_FOR_RESULT;

			for (TestStrip strip : strips) {
				if (strip.isPositiveOnDay(today)) {
					bottles = strip.getLastWeeksBottles(today);
					strips.remove(strip);
					break;
				}
			}
		}
		if (bottles.size() == 1) {
			return bottles.get(0).getId();
		}
		return -1;
	}

	void runTestSet(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips, int day) {
		int index = 0;
		for (Bottle bottle : bottles) {
			TestStrip strip = strips.get(index);
			strip.addDropOnDay(day, bottle);
			index = (index + 1) % strips.size();
		}
	}

	public static void main(String argr[]) {
		Ten_a obj = new Ten_a();
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
class Bottle {
	private boolean poisoned = false;
	private int id;

	public Bottle(int id) { this.id = id; }
	public int getId() { return id; }
	public void setAsPoisoned() { poisoned = true; }
	public boolean isPoisoned() { return poisoned; }
}

class TestStrip {
	public static int DAYS_FOR_RESULT = 7;
	private ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<ArrayList<Bottle>>();
	private int id;

	public TestStrip(int id) { this.id = id; }
	public int getId() { return this.id; }

	/*Resize list of days/drops to be large enough*/
	private void sizeDropsForDay(int day) {
		while (dropsByDay.size() <= day) {
			dropsByDay.add(new ArrayList<Bottle>());
		}
	}

	public void addDropOnDay(int day, Bottle bottle) {
		sizeDropsForDay(day);
		ArrayList<Bottle> drops = dropsByDay.get(day);
		drops.add(bottle);
	}

	private boolean hasPoison(ArrayList<Bottle> bottles) {
		for (Bottle b : bottles) {
			if (b.isPoisoned()) return true;
		}
		return false;
	}

	public ArrayList<Bottle> getLastWeeksBottles(int day) {
		if (day < DAYS_FOR_RESULT) return null;
		return dropsByDay.get(day - DAYS_FOR_RESULT);
	}

	public boolean isPositiveOnDay(int day) {
		int testDay = day - DAYS_FOR_RESULT;
		if (testDay < 0 || testDay >= dropsByDay.size()) return false;
		for (int d = 0; d <= testDay; d++) {
			ArrayList<Bottle> bottles = dropsByDay.get(d);
			if (hasPoison(bottles)) {
				return true;
			}
		}
		return false;
	}
}
