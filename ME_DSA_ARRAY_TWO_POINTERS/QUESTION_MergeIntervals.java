
import java.util.*;

class MergeIntervals {
    class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a,int[]b){
            return a[0]-b[0];
        }
    }

    public int[][] mergeIntervals(int[][] intervals) {
        //1.sort
        Arrays.sort(intervals,new IntervalComparator());
        //2.merge
        List<int[]> merged=new ArrayList<>();
        merged.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] prev=merged.get(merged.size()-1);
            int[] curr=intervals[i];
            if(curr[0]<=prev[1]){
                prev[1]=Math.max(prev[1],curr[1]);
            }
            else{
                merged.add(curr);
            }
        }
        int[][] result=new int[merged.size()][2];
        merged.toArray(result);
        return result;

    }
    

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nums = new int[n][2];

        for(int i = 0 ; i < n ;i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        int[][] results = new MergeIntervals().mergeIntervals(nums);

        for (int i = 0; i < results.length; ++i) {
            System.out.printf("%d %d\n", results[i][0], results[i][1]);
        }
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