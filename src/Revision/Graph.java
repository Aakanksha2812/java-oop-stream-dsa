package Revision;

import java.lang.reflect.Array;
import java.util.*;

import static Print.PrintFunction.printArrayMethod;

public class Graph {
    void dfsConnctedCity(int i, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
        visited[i] = true;
        for (int neighbor : list.get(i)) {
            if (!visited[neighbor]) {
                dfsConnctedCity(neighbor, list, visited);
            }
        }
    }

    int connectedCity(int[][] grid) {
        int n = grid.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] arr : grid) {
            int u = arr[0];
            int v = arr[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        for (int i = 0; i < n + 1; i++) {
            if (!visited[i]) {
                count++;
                dfsConnctedCity(i, list, visited);
            }
        }
        return count;
    }

    ArrayList<Integer> shortestPath(int[][] grid, int source) {
        int n = grid.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : grid) {
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        queue.add(source);
        //  visited[source] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    list.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return list;
    }

    int[] shortestPathDistance(int[][] grid, int source, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //  int n = grid.length;
        int[] distance = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(distance, -1);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : grid) {
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        distance[source] = 0;
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return distance;
    }

    ArrayList<Integer> shortestPathToDestination(int[][] edges, int source, int dest, int n) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        queue.add(source);
        parent[source] = source;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == dest) {
                break;
            }
            for (int neighbor : adj.get(node)) {
                if (parent[neighbor] == -1) {
                    parent[neighbor] = node;
                    queue.add(neighbor);
                }
            }
        }
        if (parent[dest] == -1) {

            return new ArrayList<>();
        }

        ArrayList<Integer> path = new ArrayList<>();
        int curr = dest;
        while (curr != source) {
            path.add(curr);
            curr = parent[curr];
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }

    boolean pathExists(int[][] grid, int n, int source, int dest) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        if (source == dest) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : grid) {
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == dest) {
                return true;
            }
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {

                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return false;
    }

    int[] shortestP(int[][] edges, int n, int source) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        queue.add(source);
        distance[source] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (distance[neighbor] == -1) {
                    queue.add(neighbor);
                    distance[neighbor] = distance[node] + 1;
                }
            }
        }
        return distance;
    }

    int gridShortestPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int i = 0, j = 0;
        if (grid[i][j] == 1) {
            return -1;
        }
        queue.add(new int[]{i, j, 1});
        visited[i][j] = true;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] pol = queue.poll();
            int row = pol[0];
            int col = pol[1];
            int dist = pol[2];
            for (int d = 0; d < 4; d++) {
                int ni = row + dx[d];
                int nj = col + dy[d];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m &&!visited[ni][nj]  && grid[ni][nj] != 1) {
                    if (ni == n - 1 && nj == m - 1) {
                        return dist + 1;
                    }
                    queue.add(new int[]{ni, nj, dist + 1});
                    visited[ni][nj] = true;
                }
            }
        }
        return -1;
    }
    int gridShortestPath2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int distance = 0;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                if (row == n - 1 && col == m - 1) {
                    return distance;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = row + dx[d];
                    int nc = col + dy[d];

                    if (nr >= 0 && nc >= 0 &&
                            nr < n && nc < m &&
                            !visited[nr][nc] &&
                            grid[nr][nc] == 0) {

                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }

            distance++;
        }

        return -1;
    }
    public static void main(String[] args) {
        Graph g = new Graph();
        int[][] grid = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        System.out.println("connected city: " + g.connectedCity(grid));
        int[][] edges = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };
        int[][] edges1 = new int[][]{
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {2, 4}};
        //  System.out.println("shortest path: " + g.shortestPath(edges, 0));
        int[] ans = g.shortestPathDistance(edges, 0, 5);
        printArrayMethod(ans);
        System.out.println();
        System.out.println(g.shortestPathToDestination(edges1, 0, 4, 5));
        int[][] edges2 = new int[][]{
                {0, 1},
                {1, 2},
                {3, 4}
        };
        System.out.println("path exists: " + g.pathExists(edges2, 5, 0, 4));
        int[] ans2 = g.shortestP(edges1, 5, 0);
        printArrayMethod(ans2);
        System.out.println();
        int[][] grid1 = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0}};
        System.out.println("minimum shortest path: "+g.gridShortestPath(grid1));
    }
}
