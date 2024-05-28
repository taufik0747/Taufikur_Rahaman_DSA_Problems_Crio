import java.util.*;

public class TownsAndPoliceStations {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of cities
        int b = sc.nextInt();  // Number of bridges

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < b; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        int s = sc.nextInt();  // Number of major cities
        ArrayList<Integer> majorCities = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            majorCities.add(sc.nextInt());
        }

        ArrayList<Integer> distances = townsAndPoliceStations(n, adj, majorCities);
        for (int distance : distances) {
            System.out.println(distance);
        }
        sc.close();
    }

    public static ArrayList<Integer> townsAndPoliceStations(int n, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> majorCities) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);  // Initialize distances with a large number (infinity)
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the queue with all major cities and set their distance to 0
        for (int majorCity : majorCities) {
            queue.add(majorCity);
            distances[majorCity] = 0;
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adj.get(current)) {
                if (distances[neighbor] == Integer.MAX_VALUE) {  // If the neighbor has not been visited
                    distances[neighbor] = distances[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // Collect results for output
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(distances[i]);
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