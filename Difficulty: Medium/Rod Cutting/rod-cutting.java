//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    int f(int i, int n, int[] price, int[][] dp){
        if(n == 0){
            return 0;
        }
        
        if(i == 0){
            return n * price[0];
        }
        
        if(dp[i][n] != -1){
            return dp[i][n];
        }
        
        int notTake = 0 + f(i - 1, n, price, dp);
        int take = Integer.MIN_VALUE;
        int len = i + 1;
        
        if(len <= n){
            take = price[i] + f(i, n - len, price, dp);
        }
        
        return dp[i][n] = Math.max(take, notTake);
    }
    
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        return f(n - 1, n, price, dp);
        
    }
}