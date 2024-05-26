import java.util.*;

public class NQueens {
    private List<List<String>> solutions;

    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(0, queens, new HashSet<>(), new HashSet<>(), new HashSet<>(), n);
        return solutions;
    }

    private void backtrack(int row, int[] queens, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2, int n) {
        if (row == n) {
            List<String> board = buildBoard(queens, n);
            solutions.add(board);
        } else {
            for (int col = 0; col < n; col++) {
                if (columns.contains(col) || diagonals1.contains(row - col) || diagonals2.contains(row + col)) {
                    continue;
                }
                
                queens[row] = col;
                columns.add(col);
                diagonals1.add(row - col);
                diagonals2.add(row + col);
                
                backtrack(row + 1, queens, columns, diagonals1, diagonals2, n);
                
                queens[row] = -1;
                columns.remove(col);
                diagonals1.remove(row - col);
                diagonals2.remove(row + col);
            }
        }
    }

    private List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '0');
            row[queens[i]] = '1';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        NQueens solver = new NQueens();
        List<List<String>> results = solver.solveNQueens(n);
        
        if (results.isEmpty()) {
            System.out.println("No Solution Exists");
        } else {
            for (List<String> result : results) {
                for (String row : result) {
                    System.out.println(row);
                }
                System.out.println(); // Separate different solutions by a blank line
            }
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