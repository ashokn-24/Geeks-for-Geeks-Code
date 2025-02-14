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
    
    static class Data implements Comparable<Data> { // Fix: Make Data class static
        int wt, node, parent;

        Data(int wt, int node) {
            this.wt = wt;
            this.node = node;
        }

        public int compareTo(Data other) {
            return this.wt - other.wt; // Min-Heap based on weight
        }
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Data> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        int[] vis = new int[V];
        Arrays.fill(vis,0);
        int sum = 0;
        pq.add(new Data(0, 0));
        
        while(!pq.isEmpty()){
            Data temp = pq.poll();
            int wt = temp.wt;
            int node = temp.node;
            
            if(vis[node] == 1) continue;
            
            vis[node] = 1;
            sum += wt;
            
            for(int[] it : adj.get(node)){
                int u = it[0];  
                int w = it[1];
                    
                if(vis[u] == 0){
                    pq.add(new Data(w,u));
                }
            }
            
        }
    
        return sum;
    }
}