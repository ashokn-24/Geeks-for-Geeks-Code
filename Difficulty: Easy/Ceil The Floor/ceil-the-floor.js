//{ Driver Code Starts
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

function main() {
    let t = parseInt(readLine());
    for (let i = 0; i < t; i++) {
        let x = parseInt(readLine());
        let input_line = readLine().split(' ');
        let arr = input_line.map(num => parseInt(num));

        let obj = new Solution();
        let ans = obj.getFloorAndCeil(x, arr);
        console.log(ans[0], ans[1]);
        console.log("~");
    }
}

// } Driver Code Ends


// User function Template for javascript

class Solution {
    getFloorAndCeil(k, arr) {
        arr.sort((a,b)=> a-b);
        let low  = 0 
        let high = arr.length - 1
        let floor = -1
        let ceil= -1
        
        while(low <= high){
            let mid = Math.floor((low+high)/2)
            
            if(arr[mid] == k){
                floor=arr[mid]
                ceil= arr[mid]
                break;
            }else if(arr[mid] < k){
                floor = arr[mid]
                low = mid + 1
            }else {
                ceil = arr[mid]
                high = mid -1
            }
            
        }
        
        return [floor,ceil]
    }
}
