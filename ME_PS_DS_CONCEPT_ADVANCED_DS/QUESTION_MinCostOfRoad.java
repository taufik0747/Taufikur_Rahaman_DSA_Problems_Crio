import java.util.*;

public class MinCostOfRoad {
    // Function to find the minimum cost to repair roads using Prim's algorithm
    public static long minCostOfRoad(int n, ArrayList<ArrayList<Integer>> edges){
        // Graph representation: adjacency list
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        // Prim's algorithm to find MST
        long totalCost = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});  // Start from node 1 with 0 cost

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            if (visited[currentNode]) continue;
            visited[currentNode] = true;
            totalCost += currentCost;

            for (int[] adj : graph[currentNode]) {
                if (!visited[adj[0]]) {
                    pq.add(new int[]{adj[0], adj[1]});
                }
            }
        }

        // Check if all nodes were visited (i.e., all cities are connected)
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return -1;  // If some cities are not connected
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of cities
        int m = sc.nextInt();  // Number of roads

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();  // City u
            int v = sc.nextInt();  // City v
            int w = sc.nextInt();  // Cost to repair road between u and v
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(u);
            edge.add(v);
            edge.add(w);
            edges.add(edge);
        }

        long ans = minCostOfRoad(n, edges);
        System.out.println(ans);
    }
}
