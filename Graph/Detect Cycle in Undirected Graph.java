import java.util.LinkedList;

class Graph {
    private final LinkedList<LinkedList<Integer>> adj;

    public Graph(int v) {
        this.adj = new LinkedList<>();

        for (int i = 0; i < v; i++)
            adj.add(new LinkedList<>());
    }

    void addEdge(int src, int des) {
        adj.get(src).add(des);
        adj.get(des).add(src);
    }

    boolean isCyclic(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (int w : adj.get(v)) {
            if (!visited[w]) {
                if (isCyclic(w, visited, v))
                    return true;
            } else if (w != parent) // w is already visited and its not parent (i.e there exist multiple paths to reach v)
                return true; // found back-edge
        }

        return false; // no back-edges found in the graph
    }
}

class LearningDS {
    public static void main(String[] args) {

        int v = 6;
        Graph graph = new Graph(v);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);

        boolean isCyclic = graph.isCyclic(0, new boolean[v], -1); 

        System.out.println(isCyclic); // true
    }
}