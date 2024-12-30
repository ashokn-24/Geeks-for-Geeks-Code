//{ Driver Code Starts
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => { inputString += inputStdin; });

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => string.trim());
    main();
});

function readLine() { return inputString[currentLine++]; }

class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

function printList(head) {
    let temp = head;
    let s = '';
    while (temp !== null) {
        s += temp.data + " ";
        temp = temp.next;
    }
    console.log(s);
}

function loopHere(head, tail, position) {
    if (position === 0) return;
    let walk = head;
    for (let i = 1; i < position; i++) walk = walk.next;
    tail.next = walk;
}

function main() {
    let t = parseInt(readLine());
    for (let i = 0; i < t; i++) {
        let input_ar1 = readLine().split(' ').map(x => parseInt(x));
        let head = new Node(input_ar1[0]);
        let tail = head;
        for (let j = 1; j < input_ar1.length; j++) {
            tail.next = new Node(input_ar1[j]);
            tail = tail.next;
        }
        let k = parseInt(readLine());
        loopHere(head, tail, k);
        let obj = new Solution();
        console.log(obj.countNodesinLoop(head));
    }
}

// } Driver Code Ends


// User function Template for javascript

/**
 * @param {Node} head
 * @returns {number}
 */

/*
class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    // Function to find the length of a loop in the linked list.
    countNodesinLoop(head) {
        let slow = head;
        let fast = head;
        let count = 1;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = fast.next;
                while(slow != fast){
                    count++
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0;
    }
}