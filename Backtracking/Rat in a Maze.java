class LearningDS {
    static int N;
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        N = maze.length;

        solveMaze(maze);
    }

    private static void solveMaze(int[][] maze) {
        int[][] sol = new int[N][N];

        if (solveMazeUtil(maze, 0, 0, sol))
            printSolution(sol);
        else
            System.out.println("Solution doesn't exist");
    }

    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            // Check if the current block is already part of solution path.
            if (sol[x][y] == 1)
                return false;

            sol[x][y] = 1;

            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            if (solveMazeUtil(maze, x - 1, y, sol))
                return true;

            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            if (solveMazeUtil(maze, x, y - 1, sol))
                return true;

            // If none of the above movements works then BACKTRACK: unmark x, y as part of solution path
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1;
    }

    private static void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }
}