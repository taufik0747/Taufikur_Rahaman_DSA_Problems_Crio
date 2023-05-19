    import java.util.*;

    class CountOccurrences {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();

            int a[] = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int res = countOccurrences(n, k, a);

            System.out.println(res);
        }

        static int countOccurrences(int n, int k, int a[]) {
        int left = 0;
        int right = n - 1;
        int firstOccurrence = binarySearch(n, k, a, true);
        int lastOccurrence = binarySearch(n, k, a, false);

        if (firstOccurrence == -1)
            return 0;
        
        return lastOccurrence - firstOccurrence + 1;
    }

    static int binarySearch(int n, int k, int a[], boolean searchFirst) {
        int left = 0;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == k) {
                result = mid;
                if (searchFirst)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (k < a[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
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