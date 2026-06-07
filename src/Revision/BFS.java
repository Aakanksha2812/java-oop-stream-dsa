package Revision;

import java.util.LinkedList;
import java.util.Queue;

import static Print.PrintFunction.printArrayMethod;
import static Print.PrintFunction.printArrayMethodChar;

public class BFS {


    int[][] zeroMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while (!q.isEmpty()) {
            int[] pol = q.poll();
            int row = pol[0];
            int col = pol[1];
            for (int d = 0; d < 4; d++) {
                int ni = row + dx[d];
                int nj = col + dy[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && !visited[ni][nj]) {
                    grid[ni][nj] = grid[row][col] + 1;
                    q.add(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
            }
        }
        return grid;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int c = image[sr][sc];
        if (c == color) {
            return image;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while (!q.isEmpty()) {
            int[] pol = q.poll();
            int row = pol[0];
            int col = pol[1];
            for (int d = 0; d < 4; d++) {
                int ni = row + dx[d];
                int nj = col + dy[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && image[ni][nj] == c) {
                    image[ni][nj] = color;
                    q.add(new int[]{ni, nj});

                }
            }
        }
        return image;
    }

    void bfs(int i, int j, int[][] grid, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = 2;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] pol = queue.poll();
            int row = pol[0];
            int col = pol[1];
            for (int d = 0; d < 4; d++) {
                int ni = row + dx[d];
                int nj = col + dy[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 1) {
                    grid[ni][nj] = 2;
                    queue.add(new int[]{ni, nj});
                }
            }
        }

    }

    int numberOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    bfs(i, j, grid, n, m);
                }
            }
        }

        return count;
    }

    void bfsRegion(int i, int j, char[][] grid, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = 'S';
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] pol = queue.poll();
            int row = pol[0];
            int col = pol[1];
            for (int d = 0; d < 4; d++) {
                int ni = row + dx[d];
                int nj = col + dy[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 'O') {
                    grid[ni][nj] = 'S';
                    queue.add(new int[]{ni, nj});
                }
            }
        }

    }

    char[][] surroundedRegion(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O') {
                bfsRegion(i, 0, grid, n, m);
            }
            if (grid[i][m - 1] == 'O') {
                bfsRegion(i, m - 1, grid, n, m);
            }

        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == '0') {
                bfsRegion(0, j, grid, n, m);
            }
            if (grid[n - 1][j] == 'O') {
                bfsRegion(n - 1, j, grid, n, m);
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
                if (grid[i][j] == 'S') {
                    grid[i][j] = 'O';
                }

            }
        }
        return grid;
    }

    int[][] nearestGate(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] pol = queue.poll();
            int row = pol[0];
            int col = pol[1];
            for (int d = 0; d < 4; d++) {
                int ni = row + dx[d];
                int nj = col + dy[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == Integer.MAX_VALUE) {
                    grid[ni][nj] = grid[row][col] + 1;
                    queue.add(new int[]{ni, nj});
                }
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        BFS b = new BFS();
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ans = b.zeroMatrix(grid);
        System.out.println(ans);
        for (int[] arr : ans) {
            printArrayMethod(arr);
            System.out.println();
        }
        int[][] image = new int[][]
                {{1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}};
        int[][] ans1 = b.floodFill(image, 1, 1, 2);
        System.out.println(
                "fill color"
        );
        for (int[] arr : ans1) {
            printArrayMethod(arr);
            System.out.println();
        }
        int[][] image1 = new int[][]
                {{1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}};
        System.out.println("number of island: " + b.numberOfIsland(image1));
        char[][] grid2 = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] ans2 = b.surroundedRegion(grid2);
        for (char[] arr : ans2) {
            printArrayMethodChar(arr);
            System.out.println();
        }
        int[][] grid3 = new int[][]{{Integer.MAX_VALUE, -1, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, 0},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};
        int[][] ans3 = b.nearestGate(grid3);
        for (int[] arr : ans3) {
            printArrayMethod(arr);
            System.out.println();
        }
    }
}
