package bapc2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AquariumArrangement {

    static class Piranha implements Comparable<Piranha> {
        int current;
        final int desired;

        public Piranha(int current, int desired) {
            this.current = current;
            this.desired = desired;
        }

        @Override
        public int compareTo(Piranha o) {
            return Integer.compare(current, o.current);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] current = new int[k];
        for (int i = 0; i < k; i++) {
            current[i] = sc.nextInt();
        }

        int[] desired = new int[k];
        for (int i = 0; i < k; i++) {
            desired[i] = sc.nextInt();
        }

        List<Piranha> piranhas = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            piranhas.add(new Piranha(current[i], desired[i]));
        }
        Collections.sort(piranhas);


    }

}
