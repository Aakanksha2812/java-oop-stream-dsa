package Revision;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
        for (int i = 0; i < n+1; i++) {
            if (!visited[i]) {
                count++;
                dfsConnctedCity(i, list, visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        int[][] grid = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        System.out.println("connected city: "+g.connectedCity(grid));
    }
}
