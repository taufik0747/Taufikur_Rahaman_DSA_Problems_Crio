import collections

def watchMe(numSeasons, prerequisites):
    # Initialize graph and in-degree array
    graph = collections.defaultdict(list)
    in_degree = [0] * numSeasons
    
    # Build graph and in-degree array
    for a, b in prerequisites:
        graph[b].append(a)
        in_degree[a] += 1
    
    # Queue for nodes with in-degree of 0
    queue = collections.deque([i for i in range(numSeasons) if in_degree[i] == 0])
    topo_order = []
    
    # BFS to generate topological order
    while queue:
        current = queue.popleft()
        topo_order.append(current)
        
        for neighbor in graph[current]:
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)
    
    # If topological order includes all seasons, return it
    if len(topo_order) == numSeasons:
        return topo_order
    else:
        return []

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    numSeasons = int(data[0])
    n = int(data[1])
    prerequisites = []
    
    index = 2
    for _ in range(n):
        a = int(data[index])
        b = int(data[index + 1])
        prerequisites.append((a, b))
        index += 2
    
    result = watchMe(numSeasons, prerequisites)
    print(*result)

if __name__ == "__main__":
    main()

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