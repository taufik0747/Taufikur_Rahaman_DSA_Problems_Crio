import java.util.*;

class CycleDirectedGraph {

    private static ArrayList<ArrayList<Integer>> adj;
    private static int[] visited;

    private static boolean dfs(int node) {
        if (visited[node] == 1) {
            // Node is in the recursion stack (Visiting), a cycle is found
            return true;
        }
        if (visited[node] == 2) {
            // Node is fully processed (Visited), no need to process again
            return false;
        }

        // Mark the node as Visiting
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor)) {
                return true;
            }
        }

        // Mark the node as Visited after all its neighbors are processed
        visited[node] = 2;
        return false;
    }

    public static int cycleDirectedGraph(int n, int[][] edges) {
        adj = new ArrayList<>();
        visited = new int[n + 1];

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Try to find a cycle starting from each unvisited node
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                if (dfs(i)) {
                    return 1; // Cycle found
                }
            }
        }
        return 0; // No cycle found
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        System.out.println(cycleDirectedGraph(n, edges));
        sc.close();
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