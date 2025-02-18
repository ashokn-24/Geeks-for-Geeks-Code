//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int m = Integer.parseInt(in.readLine());
            char mat[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String S[] = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = S[j].charAt(0);
                }
            }

            Solution ob = new Solution();
            char[][] ans = ob.fill(mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    static void dfs(int r, int c, char[][] mat, int[][] vis,int[] drow, int[] dcol){
        int n = mat.length;
        int m = mat[0].length;
        
        vis[r][c] = 1;
        
        for(int i = 0 ; i <  4 ;i++){
            int row = r + drow[i];
            int col = c + dcol[i];
            
            if(row >= 0 && row < n && col >= 0 && col < m &&
                vis[row][col] == 0 &&  mat[row][col] == 'O'){
                    dfs(row, col, mat, vis, drow, dcol);
                }
        }
    }
    
    static char[][] fill(char mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
    
        int[] drow = { 0, 0, 1, -1 };
        int[] dcol = { 1, -1, 0, 0 };
        
        for(int i = 0; i < m ;i++){
            if(vis[0][i] == 0 && mat[0][i] == 'O'){
                dfs(0, i, mat, vis, drow, dcol );
            }
            
            if(vis[n-1][i] == 0 && mat[n-1][i] == 'O'){
                dfs(n-1, i, mat, vis, drow, dcol);
            }
        }
        
        for(int i = 0; i < n ; i++){
            if(vis[i][0] == 0 && mat[i][0] == 'O'){
               dfs(i, 0, mat, vis, drow, dcol); 
            }
            
            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O'){
                dfs(i, m-1, mat, vis, drow, dcol);
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m;j++){
                if(vis[i][j] == 0 && mat[i][j] == 'O'){
                    mat[i][j] = 'X';
                }
            }
        }
        
        return mat;
    }
}