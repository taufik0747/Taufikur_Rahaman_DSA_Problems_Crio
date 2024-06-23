import java.util.*;

public class CheapestFlights {

    public static int cheapestFlights(int n, ArrayList<ArrayList<Integer>> flights, int source, int des, int k) {
        // Create a graph from the flight list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (ArrayList<Integer> flight : flights) {
            graph.putIfAbsent(flight.get(0), new ArrayList<>());
            graph.get(flight.get(0)).add(new int[]{flight.get(1), flight.get(2)});
        }

        // Priority queue to process flights; sort by total cost so far
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0, -1});  // [current city, total cost so far, stops so far (-1 because starting doesn't count as a stop)]

        // While there are flights to process
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currCity = current[0];
            int currCost = current[1];
            int stops = current[2];

            // If current city is the destination and within the allowed stops
            if (currCity == des) {
                return currCost;
            }

            // If within max stops, explore the flights from here
            if (stops < k) {
                if (!graph.containsKey(currCity)) {
                    continue;
                }
                for (int[] adj : graph.get(currCity)) {
                    pq.offer(new int[]{adj[0], currCost + adj[1], stops + 1});
                }
            }
        }

        // If no route found within the constraints
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of cities
        int e = sc.nextInt();  // Number of flights
        ArrayList<ArrayList<Integer>> flights = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            flights.add(new ArrayList<>());
            flights.get(i).add(sc.nextInt());  // Origin
            flights.get(i).add(sc.nextInt());  // Destination
            flights.get(i).add(sc.nextInt());  // Cost
        }

        int source = sc.nextInt();
        int des = sc.nextInt();
        int k = sc.nextInt();
        int ans = cheapestFlights(n, flights, source, des, k);
        System.out.println(ans);
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