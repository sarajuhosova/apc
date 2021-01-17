package bapc2020;

import java.util.*;

public class XortestPath {

    static class Node {
        int id;
        Set<Edge> outgoing;

        public Node(int id) {
            this.id = id;
            this.outgoing = new HashSet<>();
        }
    }

    static class Edge {
        Node node;
        long weight;

        public Edge(Node node, long weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class Graph {
        List<Node> nodes;

        public Graph(int n) {
            this.nodes = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                nodes.add(new Node(i));
            }
        }
    }

    static class Question {
        Node a;
        Node b;

        public Question(Node a, Node b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        Graph g = new Graph(n);

        for (int i = 0; i < m; i++) {
            Node x = g.nodes.get(sc.nextInt() - 1);
            Node y = g.nodes.get(sc.nextInt() - 1);
            long weight = sc.nextLong();
            x.outgoing.add(new Edge(y, weight));
            y.outgoing.add(new Edge(x, weight));
        }

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            questions.add(new Question(
                    g.nodes.get(sc.nextInt() - 1),
                    g.nodes.get(sc.nextInt() - 1)
            ));
        }


    }

}
