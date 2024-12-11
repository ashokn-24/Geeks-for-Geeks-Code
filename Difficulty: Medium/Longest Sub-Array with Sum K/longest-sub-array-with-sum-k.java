//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans =
                ob.lenOfLongestSubarr(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int lenOfLongestSubarr(int[] arr, int k) {
        
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        int maxLen = 0;
        int sum = 0 ;
        int n = arr.length;
         
        for(int i = 0; i<n;i++){
            sum += arr[i];
            
            if(sum == k) {
                maxLen = Math.max(maxLen,i + 1);
            }
        
            if(mp.containsKey(sum - k)){
                maxLen = Math.max(maxLen,i - mp.get(sum-k));
            }    
            
            if(!mp.containsKey(sum)){
                mp.put(sum,i);
            }
        }
        
        return maxLen;
        
    }
}
