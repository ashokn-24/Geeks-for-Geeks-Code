//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution
{
    class Data{
        int row,col,dis;
        
        public Data(int r, int c, int d){
            row = r;
            col = c;
            dis = d;
        }
    }   
    
    public int[][] nearest(int[][] grid)
    
    {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        int[][] result = new int[n][m];
        
        Queue<Data> q = new LinkedList<>();
        
        for(int i = 0; i < n;i++){
            for(int j =0; j< m ;j++){
                if(grid[i][j] == 1){
                    q.add(new Data(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        
        int[] drow = {0,0,1,-1};
        int[] dcol = {1,-1,0,0};
        
        while(!q.isEmpty()){
            Data temp = q.poll();
            int r = temp.row;
            int c = temp.col;
            int d = temp.dis;
            
            result[r][c] = d;
            
            for(int i = 0; i < 4;i++){
                int row = r + drow[i];
                int col = c + dcol[i];
                
                if(row >= 0 && row < n && 
                   col >= 0 && col < m &&
                   vis[row][col] == 0){
                       vis[row][col] = 1;
                       q.add(new Data(row, col, d + 1));
                   }
            }
        }
        return result;
    }
}