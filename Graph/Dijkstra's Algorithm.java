class Graph {
    private final int numOfNodes;
    private final int[][] matrix;

    public Graph(int numOfNodes) {
        this.numOfNodes = numOfNodes;
        this.matrix = new int[numOfNodes][numOfNodes];
    }

    void addEdge(int src, int des, int weight) {
        matrix[src][des] = weight;
        matrix[des][src] = weight;
    }

    void dijkstra(int src) {
        int[] distance = new int[numOfNodes];
        boolean[] isRelaxed = new boolean[numOfNodes];

        for (int i = 0; i < numOfNodes; i++)
            distance[i] = Integer.MAX_VALUE;

        distance[src] = 0;

        for (int i = 0; i < numOfNodes - 1; i++) {
            int u = minDistance(distance, isRelaxed);

            isRelaxed[u] = true;

            for (int v = 0; v < numOfNodes; v++) {
                if (!isRelaxed[v] && matrix[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + matrix[u][v] < distance[v]) {
                    distance[v] = distance[u] + matrix[u][v];
                }
            }
        }
        print(distance);
    }

    private int minDistance(int[] distance, boolean[] isRelaxed) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < numOfNodes; i++) {
            if (!isRelaxed[i] && distance[i] <= min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void print(int[] distance) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < numOfNodes; i++)
            System.out.println(i + " \t\t " + distance[i]);
    }
}

class LearningDS {
    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(1, 2, 8);
        graph.addEdge(7, 8, 7);
        graph.addEdge(7, 6, 1);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 5, 2);
        graph.addEdge(3, 5, 14);
        graph.addEdge(3, 4, 9);
        graph.addEdge(5, 4, 10);

        graph.dijkstra(0);
    }
}