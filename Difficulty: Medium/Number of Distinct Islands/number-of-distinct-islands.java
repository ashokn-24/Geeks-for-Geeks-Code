//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {  
    
    class Pair{
        int r, c;
        
        public Pair(int row,int col){
            r = row;
            c = col;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
    
    
    void dfs(int row, int col, int[][] grid, int[][] vis,ArrayList<Pair> lands, int r,int c){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        lands.add(new Pair(row - r, col - c));
        
        int[] drow = {0,0,1,-1};
        int[] dcol = {1,-1,0,0};
        
        for(int i = 0; i < 4;i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            
            if(nrow >= 0 && nrow < n &&
               ncol >= 0 && ncol < m &&
               vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                   dfs(nrow,ncol,grid,vis,lands,r,c);
               }
        }    
        
    }
        

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        
        HashSet<ArrayList<Pair>> st = new HashSet<>(); 
        
        for(int i = 0; i < n;i++){
            for(int j =0; j < m ; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<Pair> lands = new ArrayList<>();
                    dfs(i,j,grid,vis,lands,i,j);
                    st.add(lands);
                }
            }
        }
        
        return st.size();
    }
}
