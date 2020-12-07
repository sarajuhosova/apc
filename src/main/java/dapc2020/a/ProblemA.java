package dapc2020.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemA {

	static List<Integer> cards = new ArrayList<>();
	static int next = 0;
	static int n;
	static int removed = 0;

	static void flip(Scanner sc) {
		int index1 = sc.nextInt() - 1;
		if (cards.get(index1) == -1) {
			cards.set(index1, next + 1);
			next = (next + 1) % n;
		}
		System.out.println(cards.get(index1));

		int index2 = sc.nextInt() - 1;
		if (cards.get(index2) == -1) {
			cards.set(index2, next + 1);
			next = (next + 1) % n;
		}
		if (cards.get(index1) == cards.get(index2)) {
			removed += 2;
		}
		System.out.println(cards.get(index2));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 0; i < 2 * n; i++) {
			cards.add(-1);
		}

		while (removed < (2 * n)) {
			flip(sc);
		}
	}

}
