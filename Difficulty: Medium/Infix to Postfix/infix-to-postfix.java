//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(new Solution().infixToPostfix(br.readLine().trim()));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
              return 1;
        
            case '*':
            case '/':
              return 2;
        
            case '^':
              return 3;
        }
        return -1;
    }
    
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        StringBuilder ans = new StringBuilder();
        
        while(i < s.length()){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || 
               s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ||
               s.charAt(i) >= '0' && s.charAt(i) <= '9'
            ){
                ans.append(s.charAt(i));
            }else if(s.charAt(i) == '('){
                st.add(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                    while(!st.isEmpty() && st.peek() != '(' ){
                    ans.append(st.pop());
                }
                if (!st.isEmpty()) {
                   st.pop();
                }
            }else{
                while(!st.isEmpty() && Prec(s.charAt(i)) <= Prec(st.peek()  ) ){
                    ans.append(st.pop());
                }
                st.add(s.charAt(i));
            }
            
            i++;
        }
        
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        
        return ans.toString();
    }
}