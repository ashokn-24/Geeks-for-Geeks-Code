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
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr);
            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int f(int day, int last, int[][] arr, int[][] dp){
        if(day == 0){
            int maxi = 0;
            for(int i = 0; i < 3;i++){
                if(i != last){
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            
            return dp[day][last] = maxi;
        }
        
        if(dp[day][last] != -1){
            return dp[day][last];
        }
        
        int maxi = 0;
        
        for(int i = 0; i < 3; i++){
            if(i != last){
                int points = arr[day][i] + f(day - 1, i, arr, dp);
                
                maxi = Math.max(points, maxi);
            }
        }
        
        return dp[day][last] = maxi;
    }
    
    public int maximumPoints(int arr[][]) {
        int n = arr.length;
        
        int[][] dp = new int[n][4];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return f(n - 1, 3, arr, dp);
    }
}