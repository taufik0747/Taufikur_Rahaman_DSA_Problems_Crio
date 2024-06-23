import java.util.*;

public class CobbledStreets {

    public static int cobbledStreets(int n, ArrayList<ArrayList<Integer>> streets, int p) {
        // Priority Queue to hold the edges with minimum cost at the top
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (ArrayList<Integer> street : streets) {
            pq.add(new int[]{street.get(0), street.get(1), street.get(2)});
        }

        // Implement Union-Find to keep track of connected components
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgesUsed = 0;

        // Kruskal's algorithm to find the MST
        while (!pq.isEmpty() && edgesUsed < n - 1) {
            int[] edge = pq.poll();
            if (union(edge[0], edge[1], parent)) {
                totalCost += edge[2];
                edgesUsed++;
            }
        }

        return totalCost * p;  // Multiply by the cost per furlong
    }

    // Find function with path compression
    private static int find(int node, int[] parent) {
        if (node != parent[node])
            parent[node] = find(parent[node], parent);
        return parent[node];
    }

    // Union function with path compression
    private static boolean union(int u, int v, int[] parent) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);

        if (rootU != rootV) {
            parent[rootU] = rootV;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases
        while (t > 0) {
            t--;
            int p = sc.nextInt();  // Cost per furlong
            int n = sc.nextInt();  // Number of buildings
            int e = sc.nextInt();  // Number of streets

            ArrayList<ArrayList<Integer>> streets = new ArrayList<>();
            for (int i = 0; i < e; i++) {
                ArrayList<Integer> street = new ArrayList<>();
                street.add(sc.nextInt());  // Building a
                street.add(sc.nextInt());  // Building b
                street.add(sc.nextInt());  // Length of the street in furlongs
                streets.add(street);
            }

            int ans = cobbledStreets(n, streets, p);
            System.out.println(ans);
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