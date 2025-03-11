//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to calculate the number of subsets with a given sum
    public int f(int i, int k, int[] arr, int[][] dp) {
        if (i == 0) {
            if (k == 0 && arr[0] == 0) return 2;   // Handle case for 0 element
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
    
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return target == 0 ? 1 : 0;  // Handle empty array case
        }
        
        int[][] dp = new int[n][target + 1];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return f(n - 1, target, nums, dp);
    }


}