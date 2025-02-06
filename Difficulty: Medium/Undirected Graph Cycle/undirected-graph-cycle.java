//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public boolean bfs(int src,ArrayList<ArrayList<Integer>> adj , int[] vis){
        Queue<int[]> q = new LinkedList<>();
        vis[src] = 1;
        q.offer(new int[]{src,-1});
        
        while(!q.isEmpty()){
            int[] top = q.poll();
            int node = top[0];
            int parent = top[1];
            
            for(Integer it: adj.get(node)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.offer(new int[]{it,node});
                }else if(it != parent ){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        int[] vis = new int[v];
        
        for(int i = 0; i < v; i++){
            if(vis[i] == 0){
                 if(bfs(i,adj,vis)){
                     return true;
                 }
            }
        }
        
        return false;
               
        
    }
}