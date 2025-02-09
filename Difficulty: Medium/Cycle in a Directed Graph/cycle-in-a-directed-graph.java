//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

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
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        
        for (int i = 0;i < V;i++){
            for(int it : adj.get(i)){
                vis[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V;i++){
            if(vis[i] == 0){
                q.add(i);
            }
        }
        
        int cnt = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            cnt++;
            
            for(int it : adj.get(node)){
                vis[it]--;
                if(vis[it] == 0){
                    q.add(it);
                }
            }
        }
        
        
        if(cnt == V) return false;
        return true;
    }
}