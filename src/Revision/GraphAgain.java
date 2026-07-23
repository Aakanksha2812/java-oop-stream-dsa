package Revision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Print.PrintFunction.printArrayMethod;

public class GraphAgain {
    void dfs(int i, List<List<Integer>> graph, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " ");
        for (Integer neighbor : graph.get(i)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {

                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    List<List<Integer>> createGraph(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        boolean[] visited2 = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
            }
        }
        System.out.println();
        bfs(0, graph, visited2);
        return graph;
    }

    void dfs(int i, int j, char[][] grid, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j, grid, n, m);
        dfs(i, j + 1, grid, n, m);
        dfs(i - 1, j, grid, n, m);

        dfs(i, j - 1, grid, n, m);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, n, m);
                }
            }
        }
        return count;
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int pixels = image[sr][sc];
        q.offer(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int row = poll[0];
            int col = poll[1];
            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};
            for (int k = 0; k < 4; k++) {
                int ni = row + dx[k];
                int nj = col + dy[k];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && image[ni][nj] == pixels) {
                    image[ni][nj] = color;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
        return image;

    }

    public static void main(String[] args) {
        int n = 4;
        GraphAgain g = new GraphAgain();
        int[][] edges = new int[][]{
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3}};
        List<List<Integer>> graph = g.createGraph(edges, n);
        System.out.println();
        System.out.println(graph);
        char[][] islands = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println("number of island " + g.numIslands(islands));
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] ans = g.floodFill(image, 1, 1, 2);
        for (int[] arr : ans) {
            printArrayMethod(arr);
            System.out.println();
        }
    }
}
