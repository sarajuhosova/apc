package dapc2020.a;

import java.util.*;

public class ProblemA_4 {

	static Set<Integer> unused;
	static Set<Integer> used;
	static Map<Integer, Integer> cards;
	static int n;

	static int nextFirst() {
		if (!unused.isEmpty()) {
			int next = unused.iterator().next();
			unused.remove(next);
			used.add(next);
			return next;
		}
		int next = used.iterator().next();
		used.remove(next);
		return next;
	}

	static int getOrPutFirst(int index) {
		if (!cards.containsKey(index)) {
			int next = nextFirst();
			cards.put(index, next + 1);
		}
		return cards.get(index);
	}

	static int nextSecond(int exclude) {
		boolean removed = used.remove(exclude);
		if (!used.isEmpty()) {
			int next = used.iterator().next();
			used.remove(next);
			if (removed)
				used.add(exclude);
			return next;
		}
		if (removed)
			used.add(exclude);

		if (!unused.isEmpty()) {
			int next = unused.iterator().next();
			unused.remove(next);
			used.add(next);
			return next;
		}

		return exclude;
	}

	static int getOrPutSecond(int index, int exclude) {
		if (!cards.containsKey(index)) {
			int next = nextSecond(exclude);
			cards.put(index, next + 1);
		}
		return cards.get(index);
	}

	static void turn(Scanner sc) {
		int value1 = getOrPutFirst(sc.nextInt() - 1);
		System.out.println(value1);

		int value2 = getOrPutSecond(sc.nextInt() - 1, value1 - 1);
		System.out.println(value2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		unused = new HashSet<>(n);
		used = new HashSet<>(n);
		cards = new HashMap<>(n);

		for (int i = 0; i < n; i++) {
			unused.add(i);
		}

		int i = 1;
		while (i < (2 * n)) {
			turn(sc);
			i++;
		}
	}

}
