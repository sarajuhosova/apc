package bapc2020;

import java.util.Scanner;

public class CorruptedContest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int teams = sc.nextInt();
        int problems = sc.nextInt();

        int[] penalties = new int[teams];
        for (int i = 0; i < teams; i++) {
            penalties[i] = sc.nextInt();
        }

        boolean unsolved = penalties[teams - 1] == 0;
        boolean b = unsolved;

        int[] relatives = new int[teams];
        if (!unsolved) relatives[teams - 1] = 1;

        int distinct = 1;
        for (int i = teams - 2; i >= 0; i--) {
            if (penalties[i] != 0) b = false;
            if (penalties[i] > penalties[i + 1]) {
                relatives[i] = relatives[i + 1] + 1;
                distinct++;
            } else relatives[i] = relatives[i + 1];
        }

        if (b || (distinct == problems && !unsolved) || (distinct == problems + 1 && unsolved)) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < teams; i++) {
                builder.append(relatives[i]).append("\n");
            }
            System.out.println(builder);
        } else System.out.println("ambiguous");
    }

}
