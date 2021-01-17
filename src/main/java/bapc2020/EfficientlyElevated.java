package bapc2020;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class EfficientlyElevated {

    static class Square implements Comparable<Square> {
        int i;
        int j;
        int height;
        int covered;

        public Square(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
            this.covered = (height == 0) ? 0 : 1;
        }

        public boolean isCovered() {
            return height == covered;
        }

        public void cover() {
            covered = height;
        }

        @Override
        public int compareTo(Square o) {
            return Integer.compare(o.height, height);
        }
    }

    static class Pair {
        Square square;
        int h;

        public Pair(Square square, int h) {
            this.square = square;
            this.h = h;
        }
    }

    static int height;
    static int width;
    static Square[][] grid;

    private static void update(int i, int j, int hght) {
        Queue<Pair> q = new LinkedList<>();

        if (i - 1 >= 0 && !grid[i - 1][j].isCovered()) q.add(new Pair(grid[i - 1][j], hght));
        if (i + 1 < height && !grid[i + 1][j].isCovered()) q.add(new Pair(grid[i + 1][j], hght));
        if (j - 1 >= 0 && !grid[i][j - 1].isCovered()) q.add(new Pair(grid[i][j - 1], hght));
        if (j + 1 < width && !grid[i][j + 1].isCovered()) q.add(new Pair(grid[i][j + 1], hght));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Square s = pair.square;
            int h = Math.min(s.height, pair.h);
            s.covered = h;

            if (s.i - 1 >= 0 && !grid[s.i - 1][s.j].isCovered()) q.add(new Pair(grid[s.i - 1][s.j], h));
            if (s.i + 1 < height && !grid[s.i + 1][s.j].isCovered()) q.add(new Pair(grid[s.i + 1][s.j], h));
            if (s.j - 1 >= 0 && !grid[s.i][s.j - 1].isCovered()) q.add(new Pair(grid[s.i][s.j - 1], h));
            if (s.j + 1 < width && !grid[s.i][s.j + 1].isCovered()) q.add(new Pair(grid[s.i][s.j + 1], h));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        height = sc.nextInt();
        width = sc.nextInt();

        PriorityQueue<Square> q = new PriorityQueue<>();
        grid = new Square[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int h = sc.nextInt();
                Square square = new Square(i, j, h);
                grid[i][j] = square;
                if (h > 1) q.add(square);
            }
        }

        int amount = 0;
        while (!q.isEmpty()) {
            Square s = q.poll();

            if (s.isCovered()) continue;

            amount++;
            s.cover();
            update(s.i, s.j, s.height);
        }

        System.out.println(amount);
    }

}
