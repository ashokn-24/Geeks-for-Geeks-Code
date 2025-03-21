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
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int lc(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr[mid] <= k){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
    int fc(int[] arr, int k){
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr[mid] >= k){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    int countFreq(int[] arr, int target) {
        
        int firstOccur = fc(arr,target);
        int lastOccur = lc(arr,target);
        
        if (firstOccur == -1 || lastOccur == -1) return 0;

        return lastOccur - firstOccur + 1;
    }
}
