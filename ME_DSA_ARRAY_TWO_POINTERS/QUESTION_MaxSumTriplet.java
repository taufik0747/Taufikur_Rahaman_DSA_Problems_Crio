import java.util.*;

class MaxSumTriplet {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            long arr[] = new long[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextLong();

            long result = maxSumTriplet(n, arr);

            System.out.println(result);

        }

    }

        static long maxSumTriplet(int n, long arr[]) {
            //Intialize suffix array
            long maxSuffixArr[]=new long[n+1];
            //set the last element
            maxSuffixArr[n]=0;
            //right suffix Array
            // Calculate suffix-array containing maximum
           // value for index i, i+1, i+2, ... n-1 in
          // arr[i]
            for(int i=n-1;i>=0;i--){
                maxSuffixArr[i]=Math.max(maxSuffixArr[i+1],arr[i]);
            }
            long maxSum=0;
            //Initialize set container
            TreeSet<Long> lowValue=new TreeSet<>();
            //Insert minimum value for first comparison in the set
            lowValue.add(Long.MIN_VALUE);
            for(int i=0;i<n-1;i++){
                if(maxSuffixArr[i+1]>arr[i]){
                    maxSum=Math.max(maxSum,lowValue.lower(arr[i])+arr[i]+maxSuffixArr[i+1]);
                    // Insert arr[i] in set<> for further
            // processing
            lowValue.add(arr[i]);
                }
            }
            return maxSum;

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