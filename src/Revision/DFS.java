package Revision;

import static Print.PrintFunction.printArrayMethod;
import static Print.PrintFunction.printArrayMethodChar;

public class DFS {
    void island(int[][] grid, int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;

        island(grid, i + 1, j, n, m);
        island(grid, i, j + 1, n, m);
        island(grid, i - 1, j, n, m);
        island(grid, i, j - 1, n, m);

    }

    int countIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    island(grid, i, j, n, m);
                }
            }
        }
        return count;
    }

    int sizeOfIsland(int i, int j, int n, int m, int[][] grid, boolean[][] visited) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int count = 1;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        for (int d = 0; d < 4; d++) {
            count += sizeOfIsland(i + dx[d], j + dy[d], n, m, grid, visited);
        }
        return count;
    }

        void dfs(char[][] board, int i, int j, int n, int m,boolean[][] visited) {
            if(i<0 || j<0 || i>=n || j>=m){
                return;
            }
            if(i==n-1 || j==n-1 || i==m-1 || j==m-1){
                return;
            }
            if(visited[i][j]){
                return;
            }
            visited[i][j]=true;
            if(board[i][j]=='O' ){
                board[i][j]='X';
            }
            int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            for(int d=0;d<4;d++){
                dfs(board,dir[d][0],dir[d][1],n,m,visited);
            }
        }

        public void solve(char[][] board) {
            int n = board.length;
            int m = board[0].length;
            boolean[][] visited=new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                //    if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                        if (board[i][j] == 'O') {
                            dfs(board, i, j, n, m,visited);
                        }
                   // }
                }
            }
            //   return board;


    }
    public static void main(String[] args) {
        DFS d = new DFS();
        int[][] grid = new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {1, 0, 1}
        };
        System.out.println(d.countIsland(grid));
        int[][] grid1=new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        int n= grid1.length;
        int m= grid1[0].length;
        boolean[][] visited=new boolean[n][m];
        System.out.println("size of island: "+d.sizeOfIsland(0,1,n,m,grid1,visited));
      char[][] grid2=new char[][]  {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
      d.solve(grid2);
      for (char[] arr:grid2){
          printArrayMethodChar(arr);
          System.out.println();
      }

    }
}
