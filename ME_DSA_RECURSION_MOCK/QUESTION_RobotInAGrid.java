import java.util.*;

public class RobotInAGrid {
    List<String> path;
    boolean[][] visited;

    public List<String> findPath(int[][] grid, int n, int m) {
        path = new ArrayList<>();
        visited = new boolean[n][m];
        if (findPathUtil(grid, 0, 0, n, m)) {
            return path;
        } else {
            return Collections.singletonList("Not Possible");
        }
    }

    private boolean findPathUtil(int[][] grid, int row, int col, int n, int m) {
        // Base cases
        if (row >= n || col >= m || grid[row][col] == 1 || visited[row][col]) {
            return false;
        }
        
        // Add the current cell to the path
        path.add((row + 1) + " " + (col + 1));
        visited[row][col] = true;

        // If we reach the last cell, return true
        if (row == n - 1 && col == m - 1) {
            return true;
        }

        // Move right or down
        if (findPathUtil(grid, row, col + 1, n, m) || findPathUtil(grid, row + 1, col, n, m)) {
            return true;
        }

        // If neither move right nor down works, backtrack
        path.remove(path.size() - 1);
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        RobotInAGrid solver = new RobotInAGrid();
        List<String> result = solver.findPath(grid, n, m);
        for (String elem : result) {
            System.out.println(elem);
        }
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