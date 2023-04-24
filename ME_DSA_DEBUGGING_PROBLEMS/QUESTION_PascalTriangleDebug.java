import java.util.*;

class PascalTriangleDebug {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> result = pascalTriangle(n);

        for (List<Integer> row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> pascalTriangle(int A) {

        List<List<Integer>> R = new ArrayList<List<Integer>>();

        for (int i = 0; i < A; i++) {
            R.add(new ArrayList<>());
        }
        if (A >= 1) {
            R.get(0).add(1);
        }
        if (A > 1) {
            for (int i = 1; i < A; i++) {
                int length = R.get(i - 1).size();
                R.get(i).add(1);
                for (int j = 1; j < length; j++) {
                    R.get(i).add(R.get(i - 1).get(j) + R.get(i - 1).get(j - 1));
                }
                R.get(i).add(1);
            }
        }
        return R;
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