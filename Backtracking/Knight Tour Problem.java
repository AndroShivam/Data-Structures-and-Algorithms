import java.util.Arrays;

class LearningDS {
    static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        solveKT(BOARD_SIZE);
    }

    private static boolean solveKT(int BOARD_SIZE) {
        int[][] visited = new int[BOARD_SIZE][BOARD_SIZE];

        for (int[] cell : visited)
            Arrays.fill(cell, Integer.MIN_VALUE);

        int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

        visited[0][0] = 0;

        if (solveKTUtil(0, 0, 1, visited, xMoves, yMoves))
            printSolution(visited);
        else
            System.out.println("Solution doesn't exist");

        return true;
    }

    private static boolean solveKTUtil(int x, int y, int movesCount, int[][] visited, int[] xMoves, int[] yMoves) {
        if (movesCount == BOARD_SIZE * BOARD_SIZE)
            return true;
        
        for (int i = 0; i < xMoves.length; i++) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];

            if (isValidMove(nextX, nextY, visited)) {
                visited[nextX][nextY] = movesCount;
                if (solveKTUtil(nextX, nextY, movesCount + 1, visited, xMoves, yMoves))
                    return true;
                else
                    visited[nextX][nextY] = Integer.MIN_VALUE;
            }
        }

        return false;
    }

    private static boolean isValidMove(int x, int y, int[][] visited) {
        return (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE && visited[x][y] == Integer.MIN_VALUE);
    }

    private static void printSolution(int[][] visited) {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++)
                System.out.print(visited[x][y] + " ");
            System.out.println();
        }
    }
}