import java.util.LinkedList;
public class Six_a {
	public static void main(String argr[]) {
		Dog d1 = new Dog("sagar");
		Dog d2 = new Dog("praveen");
		Dog d3 = new Dog("jagatdeep");
		Dog d4 = new Dog("ranjeet");

		Cat c1 = new Cat("billi");
		Cat c2 = new Cat("infinite");
		Cat c3 = new Cat("man");
		Cat c4 = new Cat("sm");

		AnimalQueue aq = new AnimalQueue();
		aq.enqueue(d1);aq.enqueue(d2);aq.enqueue(d3);
		aq.enqueue(d4);aq.enqueue(c1);aq.enqueue(c2);
		aq.enqueue(c3);
		aq.enqueue(c4);

		for (Dog d : aq.dogs) System.out.print(d.name + "-" + d.getOrder() + " ");
		System.out.println();
		for (Cat c : aq.cats) System.out.print(c.name + "-" + c.getOrder() + " ");
		System.out.println();

		System.out.println(aq.dequeueDog().name);
		System.out.println(aq.dequeueCat().name);
		System.out.println(aq.dequeueAny().name);
	}
}

abstract class Animal {
	private int order;
	protected String name;
	public Animal(String n) {
		name = n;
	}

	public void setOrder(int ord) {
		order = ord;
	}

	public int getOrder() {
		return order;
	}

	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}

class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;

	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;

		if (a instanceof Dog) {
			dogs.addLast((Dog) a);
		} else if (a instanceof Cat) {
			cats.addLast((Cat) a);
		}
	}

	public Dog dequeueDog() {
		return dogs.poll();
	}

	public Cat dequeueCat() {
		return cats.poll();
	}

	public Animal dequeueAny() {
		if (dogs.size() == 0) {
			return dequeueCat();
		} else if (cats.size() == 0) {
			return dequeueDog();
		}

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.isOlderThan(cat)) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}
}

class Dog extends Animal {
	public Dog(String n) {
		super(n);
	}
}

class Cat extends Animal {
	public Cat(String n) {
		super(n);
	}
}
