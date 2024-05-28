from typing import List
from collections import deque
import sys

def wallsAndGates(n: int, m: int, grid: List[List[int]]) -> List[List[int]]:
    if not grid or not grid[0]:
        return []

    # Define directions for moving up, down, left, right
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    queue = deque()

    # Convert 'INF' from string to the Python equivalent large integer
    INF = 2147483647

    # Preprocess the grid and enqueue all gate positions
    for i in range(n):
        for j in range(m):
            if grid[i][j] == 0:
                queue.append((i, j))
            elif grid[i][j] == 'INF':
                grid[i][j] = INF

    # Perform BFS from all gate cells simultaneously
    while queue:
        x, y = queue.popleft()
        
        # Explore all 4 possible directions
        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            # Check if the new position is within bounds and is an empty room
            if 0 <= nx < n and 0 <= ny < m and grid[nx][ny] == INF:
                grid[nx][ny] = grid[x][y] + 1
                queue.append((nx, ny))

    # Any cell that remains INF is unreachable from any gate
    return grid

if __name__ == "__main__":
    # Read input
    n, m = map(int, input().split())
    grid = []
    for _ in range(n):
        line = input().split()
        grid.append([0 if x == '0' else -1 if x == '-1' else 'INF' for x in line])

    # Calculate distances to nearest gates
    result = wallsAndGates(n, m, grid)

    # Output result
    for row in result:
        print(" ".join(str(x) for x in row))

'''
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
'''