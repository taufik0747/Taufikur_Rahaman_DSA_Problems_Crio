import java.util.*;

class CourseSchedule {
    public static boolean courseSchedule(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses + 1];
        
        for (int i = 0; i <= numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            int u = pre[1];
            int v = pre[0];
            adjList.get(u).add(v);
            inDegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        return count == numCourses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        int numPrerequisites = sc.nextInt();
        int[][] edgeList = new int[numPrerequisites][2];
        for (int i = 0; i < numPrerequisites; i++) {
            edgeList[i][0] = sc.nextInt();
            edgeList[i][1] = sc.nextInt();
        }
        sc.close();
        
        boolean ans = courseSchedule(numCourses, edgeList);
        System.out.println(ans ? "true" : "false");
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