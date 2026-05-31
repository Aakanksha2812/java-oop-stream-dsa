package Revision;

import java.util.LinkedList;
import java.util.Queue;

import static Print.PrintFunction.printArrayMethod;

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
        int[] dx=new int[]{1,-1,0,0};
        int[] dy=new int[]{0,0,1,-1};
        while (!q.isEmpty()){
            int[] pol=q.poll();
            int row=pol[0];
            int col=pol[1];
            for (int d = 0; d <4 ; d++) {
                int ni=row+dx[d];
                int nj=col+dy[d];
                if (ni>=0 && nj>=0 && ni<n && nj<m && !visited[ni][nj]){
                    grid[ni][nj]=grid[row][col]+1;
                    q.add(new int[]{ni,nj});
                    visited[ni][nj]=true;
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
    }
}
