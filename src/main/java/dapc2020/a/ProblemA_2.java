package dapc2020.a;

import java.util.*;

public class ProblemA_2 {

	static int[] taken;
	static Map<Integer, Integer> cards = new HashMap<>();
	static int n;

	static int next(int order, int exclude) {
		for (int i = 0; i < taken.length; i++) {
			if (i != exclude && taken[i] == order) {
				return i;
			}
		}
		for (int i = 0; i < taken.length; i++) {
			if (i != exclude && taken[i] < 2) {
				return i;
			}
		}
		return exclude;
	}

	static int getOrPut(int order, int index, int exclude) {
		if (!cards.containsKey(index)) {
			int next = next(order, exclude);

			cards.put(index, next + 1);
			taken[next]++;
		}
		return cards.get(index);
	}

	static void turn(Scanner sc) {
		int value1 = getOrPut(0, sc.nextInt() - 1, -1);
		System.out.println(value1);

		int value2 = getOrPut(1, sc.nextInt() - 1, value1 - 1);
		System.out.println(value2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		taken = new int[n];

		int i = 1;
		while (i < (2 * n)) {
			turn(sc);
			i++;
		}
	}

}
