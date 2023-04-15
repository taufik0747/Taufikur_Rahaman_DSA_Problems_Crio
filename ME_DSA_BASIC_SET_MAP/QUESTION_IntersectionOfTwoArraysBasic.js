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
        return string.replace(/\s+/g, " ").trim();
    });
    main();
});

function readLine() {
    return inputString[currentLine++];
}

function readIntArr() {
    let str = readLine();
    str = str.split(" ");
    let arr = [];
    for ( let i = 0; i < str.length; i++ ) {
        arr.push(parseInt(str[i], 10));
    }
    return arr;
}

function print(x) {
    process.stdout.write(x + "");
}


function intersectionOfTwoArraysBasic(n, nums1, m, nums2){
     let map = new Map();
    let result=[];
 
        for(let i=0;i<n;i++)
        {
            const num = nums1[i];
            map.set(num,(map.get(num) || 0) + 1)
        }
        for(let j=0; j<m; j++)
        {
            if(map.has(nums2[j]))
            {
                let val= map.get(nums2[j]);
                if(val>0)
                {
                    result.push(nums2[j]);
                      map.set(nums2[j], --val);
                }
               
            }
        }
    return result.sort((a,b)=>a - b)
}


function main() {
  
    let n = parseInt(readLine())
    let nums1 = readIntArr();
    let m = parseInt(readLine())
    let nums2 = readIntArr();

	
	let ans = intersectionOfTwoArraysBasic(n, nums1, m, nums2);
	console.log(...ans);
}

/* 
  Crio Methodology
  
  Milestone 1: Understand the problem clearly
  1. Ask questions & clarify the problem statement clearly.
  2. *Type down* an example or two to confirm your understanding of the input/output & extend it to test cases
  
  Milestone 2: Finalize approach & execution plan
  1. Understand what type of problem you are solving.
       a. Obvious logic, tests ability to convert logic to code
       b. Figuring out logic
       c. Knowledge of specific domain or concepts
       d. Knowledge of specific algorithm
       e. Mapping real world into abstract concepts/data structures
  2. Brainstorm multiple ways to solve the problem and pick one
  3. Get to a point where you can explain your approach to a 10 year old
  4. Take a stab at the high-level logic & *type it down*.
  5. Try to offload processing to functions & keeping your main code small.
  
  Milestone 3: Code by expanding your pseudocode
  1. Have frequent runs of your code, dont wait for the end
  2. Make sure you name the variables, functions clearly.
  3. Avoid constants in your code unless necessary; go for generic functions, you can use examples for your thinking though.
  4. Use libraries as much as possible
  
  Milestone 4: Prove to the interviewer that your code works with unit tests
  1. Make sure you check boundary conditions
  2. Time & storage complexity
  3. Suggest optimizations if applicable
  */