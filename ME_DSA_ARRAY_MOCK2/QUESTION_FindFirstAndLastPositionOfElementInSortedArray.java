import java.util.*;

public class Solution {
    
    public int[] findFirstAndLastPositionOfElementInSortedArray(int[] nums, int target) {
        int[] answer = new int[2];
        answer[0]=findFirst(nums,target);
        answer[1]=findLast(nums,target);
        return answer;
    }
    private int findFirst(int[] nums,int target){
        int idx=-1;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]>=target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
            if(nums[mid]==target){
                idx=mid;
            }
           
        }
         return idx;
    }
    
        private int findLast(int[] nums,int target){
            int idx=-1;
            int start=0;
            int end=nums.length-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(nums[mid]<=target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
                if(nums[mid]==target){
                    idx=mid;
                }
               
            }
             return idx;
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