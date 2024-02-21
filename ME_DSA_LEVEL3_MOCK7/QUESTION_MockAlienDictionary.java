import java.util.*;


class MockAlienDictionary{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        for(int tests =0;tests<t;tests++)
        {
        	int n =sc.nextInt();
        	Vector<String> vec = new Vector<String>();
        	for(int i=0;i<n;i++)
        		vec.add(sc.next());
        	System.out.println(alienDictionary(vec));
        }
    }

	private static String alienDictionary(Vector<String> words) {
    // Step 1: Create a graph and populate in-degree for all characters
    Map<Character, Set<Character>> graph = new HashMap<>();
    Map<Character, Integer> inDegree = new HashMap<>();

    // Initialize in-degree and graph with all unique characters in words
    for (String word : words) {
        for (char c : word.toCharArray()) {
            graph.putIfAbsent(c, new HashSet<>());
            inDegree.putIfAbsent(c, 0);
        }
    }

    // Step 2: Build the graph
    for (int i = 0; i < words.size() - 1; i++) {
        String word1 = words.get(i);
        String word2 = words.get(i + 1);
        // Find the first non-matching character
        for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
            char parent = word1.charAt(j);
            char child = word2.charAt(j);
            if (parent != child) {
                // If the child doesn't already have an edge from the parent
                if (graph.get(parent).add(child)) {
                    inDegree.put(child, inDegree.get(child) + 1);
                }
                break;
            }
        }
    }

    // Step 3: Perform topological sort (Kahn's algorithm)
    StringBuilder order = new StringBuilder();
    Queue<Character> queue = new LinkedList<>();
    for (char c : inDegree.keySet()) {
        if (inDegree.get(c) == 0) {
            queue.add(c);
        }
    }

    while (!queue.isEmpty()) {
        char c = queue.poll();
        order.append(c);
        for (char next : graph.get(c)) {
            inDegree.put(next, inDegree.get(next) - 1);
            if (inDegree.get(next) == 0) {
                queue.add(next);
            }
        }
    }

    // Step 4: Check if topological sort is possible
    if (order.length() != graph.size()) {
        return "-1"; // Cycle detected or not all letters are connected
    }

    return order.toString();
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