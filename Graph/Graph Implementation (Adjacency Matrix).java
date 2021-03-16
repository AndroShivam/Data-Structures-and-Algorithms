class Graph {
    private final int numOfNodes;
    private final boolean isWeighted;
    private final boolean isDirected;
    private final int[][] matrix;
    private final boolean[][] isSetMatrix;

    Graph(int numOfNodes, boolean isDirected, boolean isWeighted) {
        this.numOfNodes = numOfNodes;
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;

        matrix = new int[numOfNodes][numOfNodes];
        isSetMatrix = new boolean[numOfNodes][numOfNodes];
    }

    void addEdge(int source, int destination) {
        int valueToAdd = 1;

        if (isWeighted) {
            valueToAdd = 0;
        }

        matrix[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if (!isDirected) {
            matrix[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }

    void addEdge(int source, int destination, int weight) {
        int valueToAdd = weight;
        if (!isWeighted) {
            valueToAdd = 1;
        }

        matrix[source][destination] = valueToAdd;
        isSetMatrix[source][destination] = true;

        if (!isDirected) {
            matrix[destination][source] = valueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }

    void printMatrix() {
        for (int cell[] : matrix) {
            for (int element : cell)
                System.out.print(element + " ");
            System.out.println();
        }
    }

    public void printEdges() {
        for (int i = 0; i < numOfNodes; i++) {
            System.out.print("Node " + i + " is connected to : ");
            for (int j = 0; j < numOfNodes; j++) {
                if (isSetMatrix[i][j])
                    System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public boolean hasEdge(int source, int destination) {
        return isSetMatrix[source][destination];
    }

    public int getEdgeValue(int source, int destination) {
        if (!isWeighted || !isSetMatrix[source][destination])
            return -1;
        return matrix[source][destination];
    }
}

class LearningDS {
    public static void main(String[] args) {
        Graph graph = new Graph(5, false, true);

        graph.addEdge(0, 2, 19);
        graph.addEdge(0, 3, -2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3); // The default weight is 0 if weighted == true
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printMatrix();
        System.out.println();
        graph.printEdges();
    }
}