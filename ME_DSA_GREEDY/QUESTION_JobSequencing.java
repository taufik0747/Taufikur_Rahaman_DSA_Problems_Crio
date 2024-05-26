import java.util.*;


class JobSequencing{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int deadlines[]=new int[n];
        int profits[]=new int[n];

        for(int i=0;i<n;i++)
        {
            deadlines[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            profits[i]=sc.nextInt();
        }

        System.out.println(jobSequencing(n, deadlines, profits));
    }

    static int jobSequencing(int n, int deadlines[], int profits[]){
   int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = deadlines[i];
            jobs[i][1] = profits[i];
        }
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]);

        int maxDeadline = 0;
        for (int deadline : deadlines) {
            maxDeadline = Math.max(maxDeadline, deadline);
        }

        // Track the latest available day we can do a job, using 1-based indexing for convenience
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);  // -1 means available

        int maxProfit = 0;

        for (int[] job : jobs) {
            int deadline = job[0];
            int profit = job[1];
            // Find a slot for this job in its allowable range
            for (int d = deadline; d > 0; d--) {
                if (slot[d] == -1) { // if slot is free
                    slot[d] = 1;  // mark this slot as occupied
                    maxProfit += profit;
                    break;
                }
            }
        }

        return maxProfit;
    }
}
/* 
Crio Methodology

Milestone 1: Understand the problem clearly
1. Ask questions & clarify the problem statement clearly.
2. Take an example or two to confirm your understanding of the input/output

Milestone 2: Finalize approach & execution plan
1. Understand what type of problem you are solving and see if you can recollect solving similar problems in the past
      a. Obvious logic (this would only test ability to convert logic to code)
      b. Figuring out logic
      c. Knowledge of specific algorithm, data structure or pattern
      d. Knowledge of specific domain or concepts
      e. Mapping real world into abstract concepts/data structures
2. Brainstorm multiple ways to solve the problem and pick one based on the TC/SC requirements
3. Get to a point where you can explain your approach to a 10 year old

Milestone 3 : Come up with an Instruction Manual for a 10 year old
1. Take a stab at the high-level logic & write it down like a detailed Instruction Manual for a 10 Year old where each line of the manual can be expanded into a logical line(s) of code.
2. Try to offload logic out of the main section as much as possible by delegating to functions.

Milestone 4: Code by expanding your 10 Year Olds "Instruction Manual
1. Run your code snippets at every logical step to test correctness (Helps avoid debugging larger pieces of code later)
2. Make sure you name the variables, functions clearly.
3. Use libraries as much as possible

Milestone 5: Prove that your code works using custom test cases
1. Make sure you check boundary conditions and other test cases you noted in Milestone 1
      a. If compiler is not available, dry run your code on a whiteboard or paper
2. Suggest optimizations if applicable during interviews
*/