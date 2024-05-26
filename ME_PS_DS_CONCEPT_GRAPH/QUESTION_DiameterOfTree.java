import java.util.*;

class DiameterOfTree {

    // Method to perform BFS and return the farthest node and its distance from the start node
    private static int[] bfs(int start, int n, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];

        queue.add(start);
        visited[start] = true;
        int farthestNode = start;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                    if (distance[neighbor] > distance[farthestNode]) {
                        farthestNode = neighbor;
                    }
                }
            }
        }
        return new int[]{farthestNode, distance[farthestNode]};
    }

    private static int diameterOfTree(int n, List<List<Integer>> adj) {
        // First BFS to find one end of the diameter
        int[] firstBfsResult = bfs(1, n, adj);
        int farthestFromStart = firstBfsResult[0];

        // Second BFS from the farthest node found in the first BFS
        int[] secondBfsResult = bfs(farthestFromStart, n, adj);
        return secondBfsResult[1];  // The distance in the second BFS is the diameter
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);  // Since the tree is undirected
            }

            System.out.println(diameterOfTree(n, adj));
        }
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