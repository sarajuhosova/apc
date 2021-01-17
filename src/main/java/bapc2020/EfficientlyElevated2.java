package bapc2020;

import java.util.*;

public class EfficientlyElevated2 {

    static class Square implements Comparable<Square> {
        int i;
        int j;
        int height;
        int covered;
        Set<Square> squares;

        public Square(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
            this.covered = 1;
            this.squares = new HashSet<>();
        }

        public boolean isCovered() {
            return height == covered;
        }

        public void connect(Square o) {
            this.squares.add(o);
            o.squares.add(this);
        }

        @Override
        public int compareTo(Square o) {
            return Integer.compare(o.height, height);
        }
    }

    static class Position {
        int i;
        int j;

        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (i != position.i) return false;
            return j == position.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
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
    static int toCover;

    private static void update(Square square) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(square, square.height));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Square s = pair.square;
            if (s.isCovered()) continue;

            int h = Math.min(s.height, pair.h);
            s.covered = h;
            if (s.isCovered()) {
                toCover--;
                if (toCover == 0) return;
            }

            for (Square neighbour : s.squares) q.add(new Pair(neighbour, h));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        height = sc.nextInt();
        width = sc.nextInt();

        toCover = height * width;

        List<Square> stuff = new ArrayList<>(toCover);
        Map<Position, Square> map = new HashMap<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int h = sc.nextInt();
                if (h > 1) {
                    Square square = new Square(i, j, h);
                    map.put(new Position(i, j), square);
                    stuff.add(square);

                    // still needs neighbours added
                    if (i != 0) {
                        Square up = map.get(new Position(i - 1, j));
                        if (up != null) square.connect(up);
                    }
                    if (j != 0) {
                        Square left = map.get(new Position(i, j - 1));
                        if (left != null) square.connect(left);
                    }
                } else toCover--;
            }
        }

        Collections.sort(stuff);

        int amount = 0;
//        while (!stuff.isEmpty()) {
        for (Square s : stuff) {
//            Square s = stuff.poll();

            if (s.isCovered()) continue;

            amount++;
            update(s);
            if (toCover == 0) break;
        }

        System.out.println(amount);
    }

}
