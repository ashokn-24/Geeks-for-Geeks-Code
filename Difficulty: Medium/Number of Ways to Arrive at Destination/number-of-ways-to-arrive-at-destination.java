//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static class Pair {
        int node;
        long wt;

        public Pair(long wt, int node) {
            this.node = node;
            this.wt = wt;
        }
    }

    static int countPaths(int n, List<List<Integer>> roads) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.size(); i++) {
            int u = roads.get(i).get(0);
            int v = roads.get(i).get(1);
            int wt = roads.get(i).get(2);

            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);
        
  PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.wt));

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0L, 0));
        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int node = temp.node;
            long wt = temp.wt;
            
            if (wt > dist[node]) {
                continue;
            }


            for (Pair it : adj.get(node)) {
                int adjNode = it.node;
                long adjWt = it.wt;

                if (wt + adjWt < dist[adjNode]) {
                    dist[adjNode] = wt + adjWt;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(dist[adjNode], adjNode));
                } else if (wt + adjWt == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
       return dist[n - 1] == (int) (1e9) ? 0 : ways[n - 1]; 
    }
}
