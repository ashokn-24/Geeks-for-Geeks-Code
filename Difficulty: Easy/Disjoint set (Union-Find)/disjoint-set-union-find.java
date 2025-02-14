//{ Driver Code Starts
import java.util.*;

class Disjoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = i;
            int k = sc.nextInt();
            GfG g = new GfG();
            for (int i = 0; i < k; i++) {
                String s = sc.next();
                if (s.equals("UNION")) {
                    int x = sc.nextInt();
                    int z = sc.nextInt();
                    g.unionSet(a, x, z);
                } else {
                    int x = sc.nextInt();
                    int parent = g.find(a, x);
                    System.out.print(parent + " ");
                }
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        if(x == par[x]){
            return x;
        }
        
        return par[x] = find(par, par[x]);
    }

    void unionSet(int par[], int x, int z) {
        int[] rank = new int[par.length];
        int up_x = find(par, x);
        int up_y = find(par, z);
        
        if(up_x == up_y){
            return;
        }
        
        if(rank[up_x] > rank[up_y]){
            par[up_y] = up_x;
        }else if(rank[up_y] > rank[up_x]){
            par[up_x] = up_y;
        }else{
            par[up_x] = up_y;
            rank[up_x]++;
        }
        
    }
}
