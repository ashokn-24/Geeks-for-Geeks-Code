//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public void dfs(int i, int j, int[][] vis, char[][] grid, int n, int m){
        vis[i][j] = 1;
        
        int[] drow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dcol = {-1, 0, 1, -1, 1, -1, 0, 1};

        
        for(int k = 0; k < 8; k++){
            int row = i + drow[k];
            int col = j + dcol[k];
            
            if(row >= 0 && row < n && col >= 0 && col < m &&
              vis[row][col] == 0 && grid[row][col] == 'L'){
                  vis[row][col] = 1;
                  dfs(row, col, vis, grid, n, m);
              }
        }
    }
    
    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int vis[][] = new int[n][m];
        
        int cnt = 0;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'L' && vis[i][j] == 0){
                    cnt++;
                    dfs(i, j, vis, grid, n, m);
                }
            }
        }
        
        return cnt;
    }
}