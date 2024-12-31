//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        Node zeroL = new Node(-1);
        Node oneL = new Node(-1);
        Node twoL = new Node(-1);
        
        Node l1 = zeroL;
        Node l2 = oneL;
        Node l3 = twoL;
        
        Node temp = head;
        
        while(temp != null){
            if(temp.data == 0){
                l1.next = temp;
                l1 = l1.next;
            }else if(temp.data == 1){
                l2.next = temp;
                l2 = l2.next;
            }else{
                l3.next = temp;
                l3 = l3.next;
            }
            temp = temp.next;
        }
        
        l1.next = (oneL.next != null) ? oneL.next : twoL.next;
        l2.next = (twoL.next != null) ? twoL.next : null;
        l3.next = null;

        Node newHead = zeroL.next;
        
        return newHead;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends