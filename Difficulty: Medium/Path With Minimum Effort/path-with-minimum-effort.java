//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    
    static class Data{
        int dis, row, col;
        
        public Data(int dis, int row, int col){
            this.dis = dis;
            this.row = row;
            this.col = col;
        }
    }
    
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        PriorityQueue<Data> pq = new PriorityQueue<>((x, y) -> x.dis - y.dis);
        int[][] dist = new int[rows][columns];
        
        for(int i = 0; i< rows; i++){
            for(int j = 0; j< columns; j++){
                dist[i][j] = (int) (1e9);
            }
        }
        
        pq.add(new Data(0,0,0));
        dist[0][0] = 0;
        
        int[] drow = { 0, 0, 1, -1 };
        int[] dcol = { 1, -1, 0, 0 };
        
        
        
        while(!pq.isEmpty()){
            Data temp = pq.poll();
            int dis = temp.dis;
            int r = temp.row;
            int c = temp.col;
            
            if( r == rows - 1 && c == columns -1){
                return dis;
            }
            
            for(int i = 0;i < 4; i++){
                int row = r + drow[i];
                int col = c + dcol[i];
                
                if(row >= 0 && row < rows && col >= 0 && col < columns){
                    int maxEf = Math.max(Math.abs(heights[r][c] - heights[row][col]), dis);
                    
                    if(maxEf < dist[row][col]){
                        dist[row][col] = maxEf;
                        pq.add(new Data(maxEf, row, col));
                    }
                }
            }
            
        }
        
        return -1;
    }
}
