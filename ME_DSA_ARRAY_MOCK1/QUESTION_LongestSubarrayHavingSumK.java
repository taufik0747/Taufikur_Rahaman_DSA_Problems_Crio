import java.util.*;


class LongestSubarrayHavingSumK{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(longestSubarrayHavingSumK(n,k,arr));
    }

    static int longestSubarrayHavingSumK(int n, int k, int arr[]){
        //HashMap to store the sum and index
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0,maxLen=0;
        //traverse the given array
        for(int i=0;i<n;i++){
            //accumulate the sum
            sum+=arr[i];
            //when the subarray starts from index 0
            if(sum==k){
                maxLen=i+1;
            }
            //make an entry for sum if it is not present in map or not
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            //check if sum-k is present in the map or not
            if(map.containsKey(sum-k)){
                //update the maxLen
                if(maxLen<(i-map.get(sum-k))){
                    maxLen=i-map.get(sum-k);
                }
            }
        }
        return maxLen;
    }
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