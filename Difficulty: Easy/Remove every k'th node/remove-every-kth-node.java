//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int data;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Delete_Kth_Node {
    Node head;
    Node tail;

    void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t > 0) {
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }

            int k = Integer.parseInt(in.readLine());

            Node ans = new Solution().deleteK(head, k);

            while (ans != null) {
                System.out.print(ans.data + " ");
                ans = ans.next;
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


/* Link list Node
class Node
{
    Node next;
    int data;
    Node(int d)
    {
        data = d;
        next = null;
    }
}*/
class Solution {

    Node deleteK(Node head, int k) {
        Node temp = head;
        
        int cnt = 0;
        Node prev = null;
        while(temp != null){
            cnt++;
            
            if(cnt % k == 0){
                prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
        
        return head;
    }
}