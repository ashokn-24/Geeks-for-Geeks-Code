//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        int[] hash = new int[n + 1];
        int repeat = -1;
        int miss = -1;
  
        for(int i = 0; i < n;i++){
             hash[arr[i]]++; 
        }
        
        for(int i = 1; i <= n;i++){
            if(hash[i] == 2){
                repeat = i;
            }else if(hash[i] == 0){
                miss = i;
            }
            
            if(repeat != -1 && miss != -1) break;
        }
        
        int[] ans = {repeat, miss};
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : ans) {
            result.add(num);
        }
        return result; 

    }
}
