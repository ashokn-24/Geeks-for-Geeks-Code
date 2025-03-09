//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static Boolean f(int ind, int target, int[] arr){
        if(target == 0){
            return true;
        }
        
        if(ind == 0){
            return arr[ind] == target;
        }
        
        boolean  notTake = f(ind - 1, target, arr);
        boolean  take = false;
        if(arr[ind] <= target){
            take = f(ind - 1, target - arr[ind], arr);
        }
        
        return take || notTake;
    }

    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];
        
        for(int i = 0; i < n;i++){
            dp[i][0] = true;
        }
        
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }
    
        for(int ind = 1; ind< n ;ind++){
            for(int t = 1; t <= target; t++){
                boolean  notTake = dp[ind - 1][t];
                boolean  take = false;
                if(arr[ind] <= t){
                    take = dp[ind - 1][t - arr[ind]];
                }
                
               dp[ind][t] = take || notTake;
            }
        }
        
        return dp[n - 1][target];
       
    }
}