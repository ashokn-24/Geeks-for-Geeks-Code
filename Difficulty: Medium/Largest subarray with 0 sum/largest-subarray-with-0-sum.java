//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            // Read input array as a string, split by space, and convert to integers
            String[] str = br.readLine().trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Print the result from maxLen function
            System.out.println(new Solution().maxLen(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    int maxLen(int arr[]) {
        int sum = 0;
        int count = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        
        for(int i = 0; i < arr.length ; i++){
            sum += arr[i];
            if(sum == 0){
                count = i + 1;
            }else{
                if(mp.containsKey(sum)){
                    count = Math.max(count, i - mp.get(sum));
                }else{
                    mp.put(sum, i);
                }
            }
        }
        
        return count;
    }
}