import java.util.Stack;
class Five_a {
	Stack<Integer> s;
	public Five_a() {
		s = new Stack<Integer>();
	}

	public void sort() {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			while (!r.isEmpty() && r.peek() > temp) {
				s.push(r.pop());
			}
			r.push(temp);
		}

		while (!r.isEmpty()) s.push(r.pop());
	}

	public static void main(String[] argr) {
		Five_a fa = new Five_a();
		fa.s.push(12);fa.s.push(10);fa.s.push(102);fa.s.push(121);fa.s.push(192);fa.s.push(122);
		System.out.println(fa.s.toString());
		fa.sort();
		System.out.println(fa.s.toString());
		fa.s.pop();
		System.out.println(fa.s.toString());
	}
}
