//{ Driver Code Starts
// Initial Template for javascript

"use strict";

process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let currentLine = 0;

process.stdin.on("data", (inputStdin) => { inputString += inputStdin; });

process.stdin.on("end", (_) => {
    inputString =
        inputString.trim().split("\n").map((string) => { return string.trim(); });

    main();
});

function readLine() { return inputString[currentLine++]; }

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for (; i < t; i++) {
        let n = parseInt(readLine());
        let m = parseInt(readLine());
        let obj = new Solution();
        let res = obj.nthRoot(n, m);
        console.log(res);

        console.log("~");
    }
}
// } Driver Code Ends


// User function Template for javascript

/**
 * @param {number} n
 * @param {number} m
 * @return {number}
 */
class Solution {
    nthRoot(n, m) { 
        function calN(mid,n){
            let sum =1;
            for(let i = 1;i<=n;i++){
                sum = sum*mid ;
            }
            return sum;
        }
        let ans = -1;
        let low = 1;
        let high = m;
        
        while(low <= high){
            let mid = Math.floor((low + high)/2);
            
            if(calN(mid,n) == m){
                ans = mid;
                break;
            }else if(calN(mid,n) > m){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }
}