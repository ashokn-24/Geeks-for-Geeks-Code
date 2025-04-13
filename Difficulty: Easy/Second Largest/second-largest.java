//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int getSecondLargest(int[] arr) {
        int lar1 = arr[0];
        int lar2 = -1;
        
        for(int i = 1; i< arr.length; i++){
            if(arr[i] > lar1){
                lar2 = lar1;
                lar1 = arr[i];
            }else if(arr[i] > lar2 && arr[i] != lar1){
                lar2 = arr[i];
            }
        }
        
        return lar2;
    }
}