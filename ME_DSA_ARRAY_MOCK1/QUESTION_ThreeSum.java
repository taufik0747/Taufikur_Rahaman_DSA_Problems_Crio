import java.util.Scanner;
import java.util.*;

class ThreeSum {
    
    public List<List<Integer>> threeSum(Integer[] nums) {
        //int target=0;
        //Set<List<Integer>> s= new HashSet<>();
//          Arrays.sort(nums);
//         Set<List<Integer>> ans=new HashSet<>();
//         for(int i = 0; i < nums.length-2; i++){
//             int p1 = i+1;
//             int p2 = nums.length-1;
//             while(p1 < p2){
//                 int sum = nums[i]+nums[p1]+nums[p2];
//                 if(sum == 0){
//         List<List<Integer>> result = new ArrayList<>();
//          result.add(nums[i]);
//                     result.add(nums[p1]);
//                     result.add(nums[p2]);
                    
//                     ans.add(result);
//                     p1++;
//                 }
//                 else if(sum < 0){
//                     p1++;
//                 }
//                 else{
//                     p2--;
//                 }
//             }
//         }
//         return new ArrayList<>(ans);
//     }

//         // for(int i=0;i<nums.length;i++){
//         //    int j=i+1;
//         //    int k=nums.length-1;
//         //    while(j<k){
//         //        int sum=nums[i]+nums[j]+nums[k];
//         //        if(sum==target){
//         //            s.add(Arrays.asList(nums[i],nums[j],nums[k]));
//         //            j++;
//         //            k--;
//         //        }else if(sum<target){
//         //            j++;
//         //        }else{
//         //        k--;
//         //        }
//         //    }

//         // }
//         // result.addAll(s);
// //        return result;
//   //  }
 Arrays.sort(nums);
        Set<List<Integer>> ans=new HashSet<>();
        for(int i = 0; i < nums.length-2; i++){
            int p1 = i+1;
            int p2 = nums.length-1;
            while(p1 < p2){
                int sum = nums[i]+nums[p1]+nums[p2];
                if(sum == 0){
                    ArrayList<Integer> sp = new ArrayList<>();
                    sp.add(nums[i]);
                    sp.add(nums[p1]);
                    sp.add(nums[p2]);
                    
                    ans.add(sp);
                    p1++;
                }
                else if(sum < 0){
                    p1++;
                }
                else{
                    p2--;
                }
            }
        }
        return new ArrayList<>(ans);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer nums[] = new Integer[n];
        for(Integer i = 0 ; i < n ;i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        List<List<Integer>> result = new ThreeSum().threeSum(nums);
        for (Integer i = 0; i < result.size(); ++i) {
            System.out.printf("%d %d %d\n", result.get(i).get(0), result.get(i).get(1), result.get(i).get(2));
        }
    }
};

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