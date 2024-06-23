import java.util.*;

public class Lilliput {
    static class SegmentTree {
        int[] tree;
        int n;

        public SegmentTree(int[] heights) {
            this.n = heights.length;
            // Height of segment tree is (int)ceil(log2(n)) and maximum size of segment tree is 2*(2^height)-1.
            tree = new int[n * 4];
            buildTree(heights, 0, n - 1, 0);
        }

        private void buildTree(int[] heights, int start, int end, int node) {
            if (start == end) {
                tree[node] = heights[start];
            } else {
                int mid = (start + end) / 2;
                buildTree(heights, start, mid, 2 * node + 1);
                buildTree(heights, mid + 1, end, 2 * node + 2);
                tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        public void update(int idx, int value, int start, int end, int node) {
            if (start == end) {
                // Leaf node
                tree[node] = value;
            } else {
                int mid = (start + end) / 2;
                if (idx <= mid) {
                    update(idx, value, start, mid, 2 * node + 1);
                } else {
                    update(idx, value, mid + 1, end, 2 * node + 2);
                }
                tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        public int query(int L, int R, int start, int end, int node) {
            if (R < start || end < L) { // Out of range
                return Integer.MAX_VALUE;
            }
            if (L <= start && end <= R) { // Completely in range
                return tree[node];
            }
            // Partially in range
            int mid = (start + end) / 2;
            return Math.min(query(L, R, start, mid, 2 * node + 1),
                            query(L, R, mid + 1, end, 2 * node + 2));
        }

        public void update(int idx, int value) {
            update(idx, value, 0, n - 1, 0);
        }

        public int query(int L, int R) {
            return query(L, R, 0, n - 1, 0);
        }
    }

    public static List<Integer> lilliput(int n, int[] heights, int numActions, String[] actions) {
        SegmentTree st = new SegmentTree(heights);
        List<Integer> results = new ArrayList<>();

        for (String action : actions) {
            String[] parts = action.split(" ");
            if (parts[0].equals("u")) {
                int idx = Integer.parseInt(parts[1]);
                int height = Integer.parseInt(parts[2]);
                st.update(idx, height);
            } else if (parts[0].equals("q")) {
                int l = Integer.parseInt(parts[1]);
                int r = Integer.parseInt(parts[2]);
                results.add(st.query(l, r));
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        int numActions = sc.nextInt();
        sc.nextLine(); // consume the remaining line after reading integer
        String[] actions = new String[numActions];
        for (int i = 0; i < numActions; i++) {
            actions[i] = sc.nextLine();
        }

        List<Integer> answer = lilliput(n, heights, numActions, actions);
        for (int ans : answer) {
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