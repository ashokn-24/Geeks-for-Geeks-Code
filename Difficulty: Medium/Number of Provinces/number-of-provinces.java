//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,int V){
        vis[node] = true;

        for (int i = 0; i < V; i++) {  
            if (adj.get(node).get(i) == 1 && !vis[i]) {
                dfs(i, adj, vis, V);
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] vis = new boolean[V];
        int cnt = 0;
        
        for(int i = 0; i < V ;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,vis,V);
            }
        }
        
        return cnt;
    }
};