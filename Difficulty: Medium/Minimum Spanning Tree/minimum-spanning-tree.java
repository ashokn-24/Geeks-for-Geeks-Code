//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    static class Data implements Comparable<Data> {
        int weight;
        int u;
        int v;
    
        public Data(int weight, int u, int v) {
            this.weight = weight;
            this.u = u;
            this.v = v;
        }
    
        // Implement compareTo to sort by weight in ascending order
        @Override
        public int compareTo(Data other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    
    static class DisjointSet{
        int[] size;
        int[] parent;
        
        public DisjointSet(int n){
            size = new int[n];
            parent = new int[n];
            
            for(int i = 0; i< n;i++){
                size[i] = 1;
                parent[i] = i;
            }
        } 
        
        public int find(int x){
            if(x == parent[x]){
                return x;
            }
            
            return parent[x] = find(parent[x]);
        }
        
        public void union(int x, int y){
            int parX = find(x);
            int parY = find(y);
            
            if(parX == parY){
                return;
            }
            
            if(size[parX] >= size[parY]){
                parent[parY] = parX;
                size[parX] += size[parY];
            }else{
                parent[parX] = parY;
                size[parY] += size[parX];
            }
        }
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Data> edges = new ArrayList<>();
        
        for(int i = 0; i< V; i++){
            for(int[] it: adj.get(i)){
                int adjNode = it[0];
                int wt = it[1];
                int node = i;
                
                edges.add(new Data(wt, node, adjNode));
            }
        }
        
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(V);
        
        int mstWt = 0;
        
        for(Data it : edges){
            int wt = it.weight;
            int u = it.u;
            int v = it.v;
            
            
            // if not same cmp add weight and join them by union
            if(ds.find(u) != ds.find(v)){
                mstWt += wt;
                ds.union(u, v);
            }
        }
        
        
        return mstWt;
    }
}