//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public int f(int row, int c1, int c2, int[][] grid, int n, int m, int[][][] dp){
        if(c1 <  0 || c2 < 0 || c1 >= m || c2 >= m){
            return (int) - 1e8;
        }
        
        if(row == n - 1){
            if(c1 == c2){
                return grid[row][c1];
            }else{
                return grid[row][c1] + grid[row][c2];
            }
        }
        
        if(dp[row][c1][c2] != -1){
            return dp[row][c1][c2];
        }
        
        int maxi = (int) -1e8;
        
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int val = 0;
            
                if(c1 == c2){
                  val = grid[row][c1];
                }else{
                  val = grid[row][c1] + grid[row][c2];
                }
                
                val += f(row + 1, c1 + i, c2 + j, grid, n, m, dp);
                
                maxi = Math.max(maxi, val);
            }
        }
        
        return dp[row][c1][c2] = maxi;
    }
    
    public int solve(int n, int m, int grid[][]) {
        int[][][] dp = new int[n][m][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return f(0, 0, m - 1, grid, n, m, dp);
    }
}