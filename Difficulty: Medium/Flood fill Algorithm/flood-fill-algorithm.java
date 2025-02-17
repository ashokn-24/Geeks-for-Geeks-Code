//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    
    public void dfs(int r, int c, int color, int newColor, int[][] ans, int[][] image, int[] drow, int[] dcol){
        ans[r][c] = newColor;
        
        int n = image.length;
        int m = image[0].length;
        
        
        for(int i = 0; i < 4;i++){
            int row = r + drow[i];
            int col = c + dcol[i];
            
            if(row >= 0 && row < n && col >= 0 && col < m && image[row][col] == color && ans[row][col] != newColor){
                dfs(row, col, color, newColor, ans, image, drow, dcol);
               }
        }
    }
    
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ans = image;
        int originalColor = image[sr][sc];
        int[] drow = {0,0,1,-1};
        int[] dcol = {1,-1,0,0};
        
        dfs(sr, sc,originalColor, newColor, ans,image, drow,dcol);

        
        return ans;
    }
}