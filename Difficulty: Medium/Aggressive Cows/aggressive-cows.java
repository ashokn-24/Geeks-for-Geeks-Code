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
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    static int check(int dis, int[] nums, int k){
        int cows = 1;
        int last = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - last >= dis){
                cows++;
                last = nums[i];
            }
        }
        
        return cows;
    }
    
    
    // 1 2 3 4 5 6 7 8 9
    // l       m       h
    
    public static int aggressiveCows(int[] stalls, int k) {
    
    // find max for range
       int max = stalls[0];
       
       for(int num: stalls){
           max = Math.max(max, num);
       }
       
    // sort the array to use BS
       Arrays.sort(stalls);
       
       int low = 1;
       int high = max;
       int res = 0;
       
        while(low <= high){
            int mid = (low + high) / 2;
            
        // use helper funtion to find min of max
            if(check(mid, stalls, k) >= k){
                res = mid;
                low = mid + 1;
            }else{  
                high = mid - 1;
            }
        }
        
        return res;
    }
}