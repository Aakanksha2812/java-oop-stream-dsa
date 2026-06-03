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
        int[][] edges1 = new int[][]{{0, 1},
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

    }
}
