//{ Driver Code Starts
// Initial Template for JavaScript

class DLLNode {
    constructor(val) {
        this.data = val;
        this.next = null;
        this.prev = null;
    }
}

function push(tail, new_data) {
    let newNode = new DLLNode(new_data);
    newNode.next = null;
    newNode.prev = tail;

    if (tail) {
        tail.next = newNode;
    }

    return newNode;
}

function printList(head) {
    if (!head) {
        return;
    }

    let result = [];
    while (head) {
        result.push(head.data);
        head = head.next;
    }
    console.log(result.join(" "));
}

const readline = require('readline');
const rl = readline.createInterface({input : process.stdin, output : process.stdout});

let input = [];
rl.on('line', function(line) { input.push(line); });

rl.on('close', function() {
    let t = parseInt(input[0].trim());
    let index = 1;

    while (t--) {
        let arr = input[index].trim().split(' ').map(Number);

        let head = new DLLNode(arr[0]);
        let tail = head;

        for (let i = 1; i < arr.length; i++) {
            tail = push(tail, arr[i]);
        }

        let obj = new Solution();
        head = obj.reverseDLL(head);
        printList(head);
        index += 1;
    }
});

// } Driver Code Ends


// User function Template for javascript

/*class DLLNode {
    constructor(val) {
        this.data = val;
        this.next = null;
        this.prev = null;
    }
}
*/

/**
 * @param {DLLNode} head
 * @return {DLLNode}
 */

class Solution {
    reverseDLL(head) {
       let current = head;
       let newHead = null;
       
       while(current != null){
           let pre = current.prev;
           
           current.prev = current.next;
           current.next = pre;
           
           newHead = current;
           current = current.prev;
       }
       
       return newHead;
    }
}
