import java.util.Arrays;

class Edge {
    int src, des, weight;
    Edge() {
        src = des = weight = 0;
    }
}

class Graph {
    private final int V, E;
    Edge[] edge;
    
    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        this.edge = new Edge[E];
        
        for (int i = 0; i < E; ++i)
            edge[i] = new Edge();
    }

    void BellmanFord(Graph graph, int startVertex) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE); // initialise distance array to Integer.MAX_VALUE
        
        distance[startVertex] = 0;

        for (int i = 0; i < V - 1; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].des;
                int weight = graph.edge[j].weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v])
                    distance[v] = distance[u] + weight;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].des;
            int weight = graph.edge[j].weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printArr(distance, V);
    }

    void printArr(int[] dist, int V) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
}


class LearningDS {
    public static void main(String[] args) {
        int V = 5;
        int E = 8;
        int startVertex = 0;

        Graph graph = new Graph(V, E);

        graph.edge[0].src = 0;
        graph.edge[0].des = 1;
        graph.edge[0].weight = -1;

        graph.edge[1].src = 0;
        graph.edge[1].des = 2;
        graph.edge[1].weight = 4;

        graph.edge[2].src = 1;
        graph.edge[2].des = 2;
        graph.edge[2].weight = 3;

        graph.edge[3].src = 1;
        graph.edge[3].des = 3;
        graph.edge[3].weight = 2;

        graph.edge[4].src = 1;
        graph.edge[4].des = 4;
        graph.edge[4].weight = 2;

        graph.edge[5].src = 3;
        graph.edge[5].des = 2;
        graph.edge[5].weight = 5;

        graph.edge[6].src = 3;
        graph.edge[6].des = 1;
        graph.edge[6].weight = 1;

        graph.edge[7].src = 4;
        graph.edge[7].des = 3;
        graph.edge[7].weight = -3;

        graph.BellmanFord(graph, startVertex);
    }
}
