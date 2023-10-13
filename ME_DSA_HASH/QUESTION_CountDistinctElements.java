import java.util.*;

class CountDistinctElements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> res = countDistinctElements(n, b, arr);

        for (int j : res)
            System.out.print(j + " ");

    }

    static ArrayList<Integer> countDistinctElements(int N, int B, int arr[]) {

         ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        if (B > N) {
            return result;  // Return empty result for invalid input
        }

        int dist_count = 0;

        // Calculate distinct elements in the first window
        for (int i = 0; i < B; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) == 1)
                dist_count++;
        }
        result.add(dist_count);

        // Process subsequent windows
        for (int i = B; i < N; i++) {
            int removedElement = arr[i - B];
            int count = map.getOrDefault(removedElement, 0);
            if (count == 1) {
                map.remove(removedElement);
                dist_count--;
            } else {
                map.put(removedElement, count - 1);
            }

            int newElement = arr[i];
            map.put(newElement, map.getOrDefault(newElement, 0) + 1);
            if (map.get(newElement) == 1)
                dist_count++;

            result.add(dist_count);
        }

        return result;
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