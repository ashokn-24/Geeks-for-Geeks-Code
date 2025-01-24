//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

class Item{
    int val,wt;
    
    Item(int val,int wt){
        this.val = val;
        this.wt = wt;
    }
}
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            items.add(new Item(val.get(i), wt.get(i)));
        }
        
        items.sort((a,b) -> Double.compare((double) b.val / b.wt, (double) a.val / a.wt));
        
        double maxVal = 0;
        
        for(Item item: items){
            if( item.wt <= capacity){
                maxVal += item.val;
                capacity -= item.wt;
            }else{
              maxVal += (double) item.val * capacity /  item.wt;  
              break;
            }
            
        }
        
        return maxVal;
        
    }
}