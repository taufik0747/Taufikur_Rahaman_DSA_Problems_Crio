import java.io.*;
import java.util.*;

class NumberOfIslands {

    // Direction vectors for moving up, down, left, and right
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public int numIslands(ArrayList<String> grid) {
        if (grid == null || grid.size() == 0) {
            return 0;
        }

        int n = grid.size();
        int m = grid.get(0).length();
        boolean[][] visited = new boolean[n][m];
        int numIslands = 0;

        // Iterate through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the cell is '1' and not visited, it's a new island
                if (grid.get(i).charAt(j) == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j, n, m);
                    numIslands++;
                }
            }
        }

        return numIslands;
    }

    private void dfs(ArrayList<String> grid, boolean[][] visited, int x, int y, int n, int m) {
        // Stack for DFS
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int curX = cell[0];
            int curY = cell[1];

            // Explore the 4 possible directions
            for (int k = 0; k < 4; k++) {
                int newX = curX + dx[k];
                int newY = curY + dy[k];

                // Check if the new cell is within bounds and is land ('1') and not visited
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid.get(newX).charAt(newY) == '1' && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    stack.push(new int[]{newX, newY});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // Move to the next line
        ArrayList<String> grid = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grid.add(scanner.nextLine());
        }
        int result = new NumberOfIslands().numIslands(grid);
        System.out.println(result);
        scanner.close();
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