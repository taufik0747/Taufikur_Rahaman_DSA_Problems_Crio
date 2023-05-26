import java.io.*;
import java.util.*;

class SortColors {
    public void sortColors(int[] nums) {
         int low = 0;        // Pointer for 0s
        int high = nums.length - 1;     // Pointer for 2s
        int curr = 0;       // Current pointer
        
        while (curr <= high) {
            if (nums[curr] == 0) {
                // Swap with the element at the low pointer
                swap(nums, curr, low);
                curr++;
                low++;
            } else if (nums[curr] == 2) {
                // Swap with the element at the high pointer
                swap(nums, curr, high);
                high--;
            } else {
                curr++;
            }
        }
    }
    
    // Helper method to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scanner.nextInt();
        scanner.close();

        SortColors result = new SortColors();
        result.sortColors(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.printf("%d ", nums[i]);
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