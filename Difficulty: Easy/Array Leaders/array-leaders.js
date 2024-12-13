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

function main() {
    let t = parseInt(readLine()); // Number of test cases
    for (let i = 0; i < t; i++) {
        let arr = readLine().split(' ').map(x => parseInt(x)); // Input array
        let obj = new Solution();
        const result = obj.leaders(arr);

        // Print the result in the required format
        if (result.length > 0) {
            console.log(result.join(' ')); // Print leaders
        } else {
            console.log("[]"); // Print empty list if no leaders are found
        }
        console.log("~"); // Print empty list if no leaders are found
    }
}

// } Driver Code Ends


// User function Template for javascript

/**
 * @param {number[]} a
 * @returns {number[]}
 */
class Solution {
    // Function to find the leaders in the array.
    leaders(a) {
        let n = a.length;
        let lead = [];
        let max = a[n-1];
        lead.push(a[n-1])
        
          for (let i = n - 2; i >= 0; i--) {
            if (a[i] >= max) {
              lead.push(a[i]);
              max = a[i];
            }
          }
        
        return lead.reverse();
    }
}