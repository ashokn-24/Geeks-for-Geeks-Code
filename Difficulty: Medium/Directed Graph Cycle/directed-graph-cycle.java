//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    
    public boolean dfs(int node, int[] vis, int[] path,int V, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        path[node] = 1;
        
        for(int it: adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, vis, path, V, adj) == true){
                    return true;
                }
            }else if(vis[it] == path[it]){
                return true;
            }
        }
        
        path[node] = 0;
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();   
        
       for(int i = 0; i < V; i++){
           adj.add(new ArrayList<>());
       }
       
       int vis[] = new int[V];
       int path[] = new int[V];
      
       
       for(int i = 0; i < edges.length; i++){
           int u = edges[i][0];
           int w = edges[i][1];
           
           adj.get(u).add(w);
       }
       
       for(int i = 0; i < V; i++){
           if(vis[i] == 0){
                if( dfs(i, vis, path, V, adj) == true){
                    return true;
                }
           }
       }
       
       return false;
    }
}