//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    
    public void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, int c, int d){
        vis[node] = 1;
        
        for(int it: adj.get(node)){
            if(vis[it] == 0 && !(node == c && it == d)){
                dfs(it, vis, adj, c, d);
            }
        }
    }

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length;i++){
            int u = edges[i][0];
            int w = edges[i][1];
            
            adj.get(u).add(w);
            adj.get(w).add(u);
        }
        
        int vis[] = new int[V];
        
        dfs(c, vis, adj,c, d);
        
        if(vis[d] == 1) return false;
        
        return true;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            // V and E on separate lines
            int V = Integer.parseInt(sc.nextLine().trim());
            int E = Integer.parseInt(sc.nextLine().trim());

            // Using a 2D array to store edges.
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                // Use split("\\s+") to handle one or more whitespace characters
                String[] parts = sc.nextLine().trim().split("\\s+");
                edges[i][0] = Integer.parseInt(parts[0]);
                edges[i][1] = Integer.parseInt(parts[1]);
            }

            // c and d on separate lines
            int c = Integer.parseInt(sc.nextLine().trim());
            int d = Integer.parseInt(sc.nextLine().trim());

            Solution obj = new Solution();
            boolean result = obj.isBridge(V, edges, c, d);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends