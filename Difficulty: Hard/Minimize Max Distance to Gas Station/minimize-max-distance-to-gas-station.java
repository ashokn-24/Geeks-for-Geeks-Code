//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   static class Data{
        double dis;
        int pos;
        
        public Data(double dis, int pos){
            this.dis = dis;
            this.pos = pos;
        }
    }
    
    public static double findSmallestMaxDist(int stations[], int k) {
    // create max heap to track max distace
      PriorityQueue<Data> pq = new PriorityQueue<>((a, b)-> Double.compare(b.dis, a.dis));
      
      int n = stations.length;
      
    //   track the new gas sations
      int[] gas  = new int[n - 1];
      
    //   add distance and gas station location to pq
      for(int i = 1; i < n; i++){
          int dis = stations[i] - stations[i - 1];
          pq.add(new Data(dis, i - 1));
      }
      
      int cnt = 0;
      
    //   loop through pq calculate dis 
      while(cnt < k){
          Data it = pq.poll();
          double dis = it.dis;
          int pos = it.pos;
          
          gas[pos]++;
          double newDis = (stations[pos + 1] - stations[pos]) * 1.0 / (gas[pos] + 1);
          
          pq.add(new Data(newDis, pos));
          cnt++;
      }

        return pq.peek().dis;
    }
}
