//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       
System.out.println("~");
}
    }
}

// } Driver Code Ends


class Solution
{
    
    class Pair{
        int len;
        String word;
        
        public Pair(String s, int l){
            len = l;
            word = s;
        }
    }
    
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> st = new HashSet<>();
        
        for(String word: wordList){
            st.add(word);
        }
        st.remove(startWord);
        q.add(new Pair(startWord, 1));
        
        while(!q.isEmpty()){
            Pair temp = q.poll();
            String s = temp.word;
            int len = temp.len;
            
            if(s.equals(targetWord)){
                return len;
            }
            
            for(int i = 0; i < s.length() ;i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char replacedCharArray[] = s.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    
                    if(st.contains(replacedWord) == true){
                        q.add(new Pair(replacedWord, len + 1));
                        st.remove(replacedWord);
                    }
                }
            }
        }
        
        return 0;
    }
}