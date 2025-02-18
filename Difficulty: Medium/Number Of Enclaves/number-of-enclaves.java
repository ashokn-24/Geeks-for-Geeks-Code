//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        q.add(new int[]{i, j}); 
                        vis[i][j] = 1;
                    }
                }
            }
        }
        
        int[] drow = { 0, 0, 1, -1 };
        int[] dcol = { 1, -1, 0, 0 };

        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            
            for(int i =0 ; i< 4 ;i++){
                int row = r + drow[i];
                int col = c + dcol[i];
                
                if(row >= 0 && row < n && col >= 0 && col < m && 
                    vis[row][col] == 0 && grid[row][col] == 1){
                        q.add(new int[]{row,col});
                        vis[row][col] = 1;
                    }
            }
        }
        
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                   cnt++;
                }
            }
        }
    
    return cnt;
       
    }
}