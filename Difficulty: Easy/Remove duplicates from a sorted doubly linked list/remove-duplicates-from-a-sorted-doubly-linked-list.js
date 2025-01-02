//{ Driver Code Starts
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function printList(obj)
{
    let s = '';
    while(obj !== null){
        s += obj.data;
        s += " ";
        obj = obj.next;
    }
    console.log(s);
}

function main() {
    let t = parseInt(readLine());
    for(let i=0;i<t;i++)
    {
        let n = parseInt(readLine());
        let arr = readLine().trim().split(" ").map((x) => parseInt(x));
        let head = new Node(arr[0]);
        let tail = head;
        for(let j=1;j<n;j++){
            tail.next = new Node(arr[j]);
            tail.next.prev = tail;
            tail = tail.next;
        }
        let obj = new Solution();
        let res = obj.removeDuplicates(head);
        printList(res);
    
console.log("~");
}
}
// } Driver Code Ends


//Back-end complete function Template for JAVASCRIPT

/**
 * Node Class
 * @param {any} data - value stored in node
 * @class
 */
class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Solution {
    /**
     * Function to remove duplicates from unsorted linked list.
     * @param {Node} head
     * @returns {Node}
     */
     removeDuplicates(head) {
        let temp = head;
        
        while(temp != null && temp.next != null){
            let nxt = temp.next;
            while(nxt != null && temp.data == nxt.data){
                nxt = nxt.next;
            }
            
            temp.next = nxt;
            if (nxt) {
                nxt.prev = temp;
            }
            
            temp = temp.next;
        }
        
        return head;
     }
}