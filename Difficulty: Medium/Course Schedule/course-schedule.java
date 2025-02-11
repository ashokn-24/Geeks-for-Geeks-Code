//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        
System.out.println("~");
}
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int[] findOrder(int N, int P, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        
        
        for (int i = 0; i < P; i++) {
            int v = prerequisites.get(i).get(0);
            int u = prerequisites.get(i).get(1);
            adj.get(u).add(v);
        }
        

        int[] indegree = new int[N];
        Queue<Integer> q = new LinkedList<>();
        
        // finding inderee
        for(int i = 0; i < N;i++){
          for(int it : adj.get(i)){
              indegree[it]++;
          }
        }
        
        // adding node which have 0 value in queue
        for(int i = 0; i< N;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            res.add(node);
            
            for(int it: adj.get(node)){
                indegree[it]--;
                
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        int[] resultArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resultArray[i] = res.get(i);
        }
    
        
        if(resultArray.length == N) return resultArray;
        int[] arr = {};
        return arr;
    }
}