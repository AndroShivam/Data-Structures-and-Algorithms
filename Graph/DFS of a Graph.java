import java.util.*;

class Graph {
    int v;
    LinkedList<LinkedList<Integer>> adj;

    Graph(int v) {
        this.v = v;
        adj = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void DFS(int start) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;
            }

            for (int n : adj.get(current)) {
                if (!visited[n]) {
                    stack.push(n);
                }
            }
        }
    }
}

class LearningDS {
    public static void main(String[] args) {

        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        g.DFS(0);
    }
}