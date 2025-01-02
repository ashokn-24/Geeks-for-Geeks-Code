//{ Driver Code Starts
// Initial Template for javascript
// Position this line where user code will be pasted.
// Initial Template for javascript
// Position this line where user code will be pasted.
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => { inputString += inputStdin; });

process.stdin.on('end', _ => {
    inputString =
        inputString.trim().split('\n').map(string => { return string.trim(); });

    main();
});

function readLine() { return inputString[currentLine++]; }

class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

function main() {
    let t = parseInt(readLine());
    while (t--) {
        let target = parseInt(readLine());
        let n = parseInt(readLine());
        let a = readLine().split(' ').map(Number);

        let head = new Node(a[0]);
        let tail = head;
        for (let i = 1; i < n; i++) {

            tail.next = new Node(a[i]);
            tail.next.prev = tail;
            tail = tail.next;
        }
        let ob = new Solution();
        let ans = ob.findPairsWithGivenSum(head, target);
        if (ans.length === 0) {
            console.log("-1");
        } else {
            let result = ans.map(pair => `(${pair[0]},${pair[1]})`).join(' ');
            console.log(result);
        }
        console.log("~");
    }
}

// } Driver Code Ends


// User function Template for javascript
// class Node {
//     constructor(data) {
//         this.data = data;
//         this.next = null;
//         this.prev = null;
//     }
// }

class Solution {
    // Function to find pairs in the linked list with the given sum
    findPairsWithGivenSum(head, target) {
        let temp = head;
        let last = temp;
        let ans = [];
        
        while(last.next != null){
            last = last.next;
        }
        
        while(temp.data < last.data){
            let sum = temp.data + last.data
            if(sum == target){
                ans.push([temp.data, last.data]); 
                temp = temp.next;
                last = last.prev;
            }else if(sum> target){
                last = last.prev;
            }else{
                temp = temp.next;
       
            }
        }
        
        return ans;
    }
}