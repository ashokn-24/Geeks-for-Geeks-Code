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
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    static int check(int maxPage, int k, int[] arr){
        int stu = 1;
        int sum = 0;
        
        for(int pages: arr){
            if (pages > maxPage) return Integer.MAX_VALUE;
            
            if(sum + pages <= maxPage){
                sum += pages;
            }else{
                stu++;
                sum = pages;
            }
        }
        
        return stu;
    }
    
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        
        if(n < k){
            return -1;
        }
        
        int max = arr[0];
        int sum = 0;
        
        for(int num : arr){
            sum += num;
            max = Math.max(num, max);
        }
        
        int low = max;
        int high = sum;
        int res = -1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(check(mid, k, arr) <= k){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return res;
 
    }
}