import java.util.LinkedList;

class Graph {
    private final LinkedList<LinkedList<Integer>> adj;
    private final int V;

    public Graph(int V) {
        this.V = V;
        this.adj = new LinkedList<>();
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    void addEdge(int src, int des) {
        adj.get(src).add(des);
    }

    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack) {
        if (!visited[v]) {
            visited[v] = true;
            recStack[v] = true;

            for (int neighbor : adj.get(v)) {
                if (!visited[neighbor] && isCyclicUtil(neighbor, visited, recStack))
                    return true;
                else if (recStack[neighbor])
                    return true;
            }
        }
        recStack[v] = false;
        return false;
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack))
                return true;
        }

        return false;
    }
}

class LearningDS {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        boolean containsCycle = graph.isCyclic();
        System.out.println(containsCycle);
    }
}