//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static class Data{
        int row;
        int col;
        int time;
        
        public Data(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }
    
    public int orangesRotting(int[][] mat) {
        Queue<Data> q = new  LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        
        int vis[][] = new int[n][m];
        int freshOranges = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 2){
                    q.add(new Data(i, j, 0));
                    vis[i][j] = 2;
                }else if(mat[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0){
            return 0;
        }
        
        int[] drow = { 0, 0, 1, -1 };
        int[] dcol = { 1, -1, 0, 0 };
        int tm = 0;
        int cnt = 0;
        
        while(!q.isEmpty()){
            Data temp = q.poll();
            int r = temp.row;
            int c = temp.col;
            int t = temp.time;
            tm = Math.max(t, tm);
            
            for(int i = 0; i < 4; i++){
                int row = r + drow[i];
                int col = c + dcol[i];
                
                if(row >= 0 && row < n && col >= 0 && col < m &&
                vis[row][col] == 0 && mat[row][col] == 1){
                    q.add(new Data(row, col, t + 1));
                    vis[row][col] = 2;
                    cnt++;
                }
            }
        }
        
        if(freshOranges != cnt){
            return -1;
        }
        
        return tm;
    }
}