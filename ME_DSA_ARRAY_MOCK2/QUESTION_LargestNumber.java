import java.util.*;
import java.util.Scanner;

class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums.length==0)
            return "";
            String[] conv=new String[nums.length];
            for(int i=0;i<nums.length;i++){
                conv[i]=Integer.toString(nums[i]);
            }
            Arrays.sort(conv,(a,b)->(b+a).compareTo(a+b));
            StringBuilder result=new StringBuilder();
            if(conv[0].equals("0"))
            return "0";
            for(int i=0;i<conv.length;i++){
                result.append(conv[i]);
            }
            return result.toString();

        }
    

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        String result = new LargestNumber().largestNumber(nums);

        System.out.println(result);
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