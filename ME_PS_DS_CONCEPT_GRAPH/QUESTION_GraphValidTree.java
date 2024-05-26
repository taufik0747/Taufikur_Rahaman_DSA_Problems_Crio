import java.util.*;

public class GraphValidTree {

    static int[] parent;  // Parent array for union-find
    static int[] rank;    // Rank array for union-find

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edges = new int[m][2];

        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        
        System.out.println(isValidTree(n, edges) ? 1 : 0);
        scanner.close();
    }
    
    static boolean isValidTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;  // Quick check on the number of edges
        
        // Initialize union-find structure
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        // Process each edge
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {  // If union returns false, a cycle was detected
                return false;
            }
        }
        
        return true;  // Passed all checks
    }
    
    static int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);  // Path compression
        }
        return parent[node];
    }
    
    static boolean union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        
        if (root1 == root2) return false;  // Same root means there is a cycle
        
        // Union by rank
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
        
        return true;
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