import java.io.*;
import java.util.*;

class MatrixTraversal  {

  public List<Integer> matrixTraversal(int[][] matrix, int currPosRow, int currPosCol, int dirToMove, int stepsToMove) {
    List<Integer> res = new ArrayList<Integer>();
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
    int dirIndex = dirToMove - 1;
    while (stepsToMove > 0) {
      int nextRow = currPosRow + dirs[dirIndex][0];
      int nextCol = currPosCol + dirs[dirIndex][1];
      if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length) {
        res.clear();
        res.add(-1);
        return res;
      }
      res.add(matrix[nextRow][nextCol]);
      currPosRow = nextRow;
      currPosCol = nextCol;
      stepsToMove--;
    }
    return res;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] matrix = new int[n][m];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    int currPosX = scanner.nextInt();
    int currPosY = scanner.nextInt();
    int dirToMove = scanner.nextInt();
    int stepsToMove = scanner.nextInt();

    scanner.close();
     List<Integer> result = new MatrixTraversal().matrixTraversal(matrix, currPosX, currPosY, dirToMove, stepsToMove);

    for (int i = 0; i < result.size(); ++i) {
      System.out.printf("%d ", result.get(i));
    }
  }
}


/* 
  Crio Methodology
  
  Milestone 1: Understand the problem clearly
  1. Ask questions & clarify the problem statement clearly.
  2. *Type down* an example or two to confirm your understanding of the input/output & extend it to test cases
  
  Milestone 2: Finalize approach & execution plan
  1. Understand what type of problem you are solving.
       a. Obvious logic, tests ability to convert logic to code
       b. Figuring out logic
       c. Knowledge of specific domain or concepts
       d. Knowledge of specific algorithm
       e. Mapping real world into abstract concepts/data structures
  2. Brainstorm multiple ways to solve the problem and pick one
  3. Get to a point where you can explain your approach to a 10 year old
  4. Take a stab at the high-level logic & *type it down*.
  5. Try to offload processing to functions & keeping your main code small.
  
  Milestone 3: Code by expanding your pseudocode
  1. Have frequent runs of your code, dont wait for the end
  2. Make sure you name the variables, functions clearly.
  3. Avoid constants in your code unless necessary; go for generic functions, you can use examples for your thinking though.
  4. Use libraries as much as possible
  
  Milestone 4: Prove to the interviewer that your code works with unit tests
  1. Make sure you check boundary conditions
  2. Time & storage complexity
  3. Suggest optimizations if applicable
  */