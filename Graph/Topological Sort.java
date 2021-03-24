import java.util.LinkedList;
import java.util.Stack;

class Graph {
    private LinkedList<LinkedList<Integer>> adj;
    private int V;

    public Graph(int V) {
        this.V = V;
        this.adj = new LinkedList<>();

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    void addEdge(int src, int des) {
        adj.get(src).add(des);
    }

    void topologicalSort() {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topologicalSortUtil(i, stack, visited);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    void topologicalSortUtil(int v, Stack<Integer> stack, boolean[] visited) {
        visited[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, stack, visited);
            }
        }

        stack.push(v);
    }
}

class LearningDS {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.topologicalSort();
    }
}