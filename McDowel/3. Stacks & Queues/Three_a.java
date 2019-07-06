import java.util.*;
class Three_a {
	ArrayList<StackArrayImplementation> stacks;
	public Three_a() {
		stacks = new ArrayList<StackArrayImplementation>();
	}

	public void push(int v) throws Exception {
		StackArrayImplementation last = getLastElement();
		if (last != null && !last.isFull()) {
			last.push(v);
		} else {
			StackArrayImplementation st = new StackArrayImplementation();
			st.push(v);
			stacks.add(st);
		}
	}

	public int pop() throws Exception {
		StackArrayImplementation last = getLastElement();
		if (last == null) throw new EmptyStackException();
		int v = last.pop();
		if (last.size == 0) stacks.remove(stacks.size() - 1);
		return v;
	}
	
	private StackArrayImplementation getLastElement() {
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}

	public static void main(String argr[]) throws Exception {
		Three_a sos = new Three_a();
		sos.push(10);
		sos.push(20);sos.push(10);
		sos.push(20);sos.push(10);
		sos.push(20);sos.push(10);
		sos.push(20);sos.push(10);
		sos.push(20);sos.push(10);
		sos.push(20);sos.push(10);
		sos.push(20);sos.push(10);
		sos.push(20);sos.push(10);
		sos.push(20);
		System.out.println(Arrays.toString(sos.getLastElement().stack));
		System.out.println(sos.stacks);
	}
}
