//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
class Val implements Comparable<Val> {
    int row, col, dis;

    public Val(int row, int col, int dis) {
        this.row = row;
        this.col = col;
        this.dis = dis;
    }

    @Override
    public int compareTo(Val other) {
        return Integer.compare(this.dis, other.dis); 
    }
}


    int shortestPath(int[][] grid, int[] src, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<Val> pq = new PriorityQueue<>();
        int[][] dist = new int[n][m];

        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[src[0]][src[1]] = 0;

        pq.add(new Val(src[0], src[1], 0));

        int[] dr = {0, 0, 1, -1}; 
        int[] dc = {1, -1, 0, 0}; 

        while (!pq.isEmpty()) {
            Val temp = pq.poll();
            int r = temp.row, c = temp.col, d = temp.dis;

            if (r == destination[0] && c == destination[1]) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int row = r + dr[i];
                int col = c + dc[i];

                if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1) {
                    int newDist = d + 1;
                    if (newDist < dist[row][col]) {
                        dist[row][col] = newDist;
                        pq.add(new Val(row, col, newDist));
                    }
                }
            }
        }

        return -1;
    }
}
