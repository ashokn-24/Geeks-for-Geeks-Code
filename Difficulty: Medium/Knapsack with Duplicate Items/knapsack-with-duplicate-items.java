//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int W = Integer.parseInt(in.readLine().trim());
            String line2[] = in.readLine().trim().split(" ");
            int N = line2.length;
            int val[] = new int[N];
            for (int i = 0; i < N; i++) val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split(" ");
            int wt[] = new int[N];
            for (int i = 0; i < N; i++) wt[i] = Integer.parseInt(line3[i]);

            Solution ob = new Solution();
            System.out.println(ob.knapSack(val, wt, W));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    
   static int f(int i, int w, int[] val, int[] wt, int[][] dp){
        if(w == 0){
            return 0;
        }
        
        if(i == 0){
            return (w / wt[0]) * val[0];
        }
        
        if(dp[i][w] != -1){
            return dp[i][w];
        }
        
        int notTake = 0 + f(i - 1, w, val, wt, dp);
        int take = Integer.MIN_VALUE;
        
        if(wt[i] <= w){
            take = val[i] + f(i, w - wt[i], val, wt, dp);
        }
        
        return dp[i][w] = Math.max(take, notTake);
    }
    
    static int knapSack(int val[], int wt[], int c) {
        int n = val.length;
        int[][] dp = new int[n][c + 1];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        return f(n - 1, c, val, wt, dp);

    }
    
}