import java.util.*;

class KnightWalk {
    
    // Possible moves for a knight in chess
    private static final int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    private static final int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] startingPos = {sc.nextInt(), sc.nextInt()};
        int[] endingPos = {sc.nextInt(), sc.nextInt()};
        System.out.println(knightWalk(startingPos, endingPos, n));
        sc.close();
    }

    static int knightWalk(int[] startingPos, int[] endingPos, int n) {
        int startX = startingPos[0], startY = startingPos[1];
        int endX = endingPos[0], endY = endingPos[1];

        // If the starting position is the same as the target position
        if (startX == endX && startY == endY) {
            return 0;
        }

        // Queue for BFS and visited array
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        
        // Initialize the queue with the starting position and mark it visited
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], moves = current[2];

            // Check all possible moves of the knight
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // Check if the new position is within the bounds of the chessboard and not visited
                if (newX > 0 && newX <= n && newY > 0 && newY <= n && !visited[newX][newY]) {
                    // If the new position is the target position
                    if (newX == endX && newY == endY) {
                        return moves + 1;
                    }

                    // Mark the new position as visited and enqueue it with the updated number of moves
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, moves + 1});
                }
            }
        }

        // If the target is not reachable, return -1 (though in this problem context it should always be reachable)
        return -1;
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