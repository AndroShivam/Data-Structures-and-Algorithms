import java.util.*;

class Graph<T> {
    private Map<T, LinkedList<T>> map;

    public Graph() {
        map = new HashMap<>();
    }

    public void addVertex(T s) {
        map.put(s, new LinkedList<>());
    }

    public void addEdge(T source, T destination, boolean undirected) {
        if (!map.containsKey(source))
            addVertex(source);
        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);

        if (undirected) {
            map.get(destination).add(source);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T v : map.keySet()) {
            builder.append(v.toString()).append(": ");
            for (T w : map.get(v)) {
                builder.append(w.toString()).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}

class LearningDS {
    public static void main(String[] args) {

        Graph<Integer> graph = new Graph<>();

        graph.addEdge(0, 1, true);
        graph.addEdge(0, 4, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(1, 4, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 4, true);

        System.out.println(graph.toString());
    }
}

// Output

// 0: 1 4
// 1: 0 2 3 4
// 2: 1 3
// 3: 1 2 4
// 4: 0 1 3 