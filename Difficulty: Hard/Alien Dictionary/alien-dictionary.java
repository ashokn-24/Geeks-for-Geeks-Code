//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    
 public static ArrayList<Integer> topoSort(int v, ArrayList<ArrayList<Integer>> adj, int[] inDegree) {
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            
            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // If all nodes are not covered, it means there's a cycle
        if (res.size() < v) {
            return new ArrayList<>();
        }

        return res;
    }
    
    
    public String findOrder(String[] words) {
        
        Set<Character> uniqueChars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                uniqueChars.add(c);
            }
        }
        
        int v = uniqueChars.size();
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < 26; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[26];
        
        for(int i = 0; i < words.length - 1; i++){
            String s1 = words[i];
            String s2 = words[i + 1];
            
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";  
            }
            
            int len = Math.min(s1.length(),s2.length());
            for(int j = 0; j < len; j++){
                char u = s1.charAt(j);
                char w = s2.charAt(j);
                
                if(u != w){
                    adj.get(u - 'a').add(w - 'a');
                    inDegree[w - 'a']++;
                    break;
                }
            }
        }
        
                
        ArrayList<Integer> topo = topoSort(26,adj,inDegree);
        
        if (topo.isEmpty()) return "";
        
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            if (uniqueChars.contains((char) (it + 'a'))) {
                ans.append((char) (it + 'a'));
            }
        }

        return ans.toString();
    }
}

//{ Driver Code Starts.

public class GFG {
    private static boolean validate(String[] original, String order) {
        Map<Character, Integer> mp = new HashMap<>();
        for (String word : original) {
            for (char ch : word.toCharArray()) {
                mp.put(ch, 1);
            }
        }
        for (char ch : order.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            mp.remove(ch);
        }
        if (!mp.isEmpty()) {
            return false;
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            indexMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < original.length - 1; i++) {
            String a = original[i];
            String b = original[i + 1];
            int k = 0, n = a.length(), m = b.length();

            while (k < n && k < m && a.charAt(k) == b.charAt(k)) {
                k++;
            }

            if (k < n && k < m &&
                indexMap.get(a.charAt(k)) > indexMap.get(b.charAt(k))) {
                return false;
            }
            if (k != n && k == m) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); // Number of test cases

        while (t-- > 0) {
            String[] words = sc.nextLine().split(" ");
            String[] original = Arrays.copyOf(words, words.length);

            Solution ob = new Solution();
            String order = ob.findOrder(words);

            if (order.isEmpty()) {
                System.out.println("\"\"");
            } else {
                System.out.println(validate(original, order) ? "true" : "false");
            }
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends