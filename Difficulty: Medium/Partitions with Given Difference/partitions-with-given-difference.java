//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countPartitions(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
 public int f(int i, int k, int[] arr, int[][] dp) {
        if (i == 0) {
            if (k == 0 && arr[0] == 0) return 2;
            if (k == 0 || arr[0] == k) return 1;
            return 0;
        }
        
        if (dp[i][k] != -1) {
            return dp[i][k];
        }
        
        int notTake = f(i - 1, k, arr, dp);
        int take = 0;
        
        if (arr[i] <= k) {
            take = f(i - 1, k - arr[i], arr, dp);
        }
        
        return dp[i][k] = notTake + take;
    }
    
    int countPartitions(int[] arr, int d) {
        int n =arr.length;
        int s = 0;
        
        for(int num: arr){
            s += num;
        }
        
        if(s - d < 0 || (s - d) % 2 != 0){
            return 0;
        }
        
        int[][] dp = new int[n][(s - d) / 2 + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return f(n - 1, (s - d) / 2, arr, dp);

    }
}
