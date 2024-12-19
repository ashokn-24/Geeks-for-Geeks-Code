//{ Driver Code Starts
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

function main() {
    let tc = parseInt(readLine());
    while (tc > 0) {
        let arr = readLine().split(' ').map(Number);
        let k = parseInt(readLine());

        let obj = new Solution();
        let res = obj.findFloor(arr, k);

        console.log(res); // Print the array as a space-separated string
        tc--;
    }
}

// } Driver Code Ends


// User function Template for javascript

/**
 * @param {number[]} arr
 * @param {number} k
 * @returns {number}
 */

class Solution {

    findFloor(arr, k) {
       let left = 0;
       let right = arr.length -1 ;
       let floor = -1;
       
       while (left <= right){
           let mid = Math.floor((left + right)/2);
        
           if(arr[mid] <= k){
               floor = mid;
               left = mid + 1;
           }else{
               right = mid - 1;
           }
       }
       
       return floor;
    }
}