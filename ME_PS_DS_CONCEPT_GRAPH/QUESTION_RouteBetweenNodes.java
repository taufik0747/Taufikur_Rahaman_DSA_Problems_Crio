import java.util.*;

public class RouteBetweenNodes {
    
    public boolean routeBetweenNodes(int source, int destination, int n, ArrayList<ArrayList<Integer>> graph) {
        if (source == destination) {
            // Check if there is any self-loop or path back to itself.
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            
            queue.add(source);
            visited[source] = true;
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int neighbor : graph.get(current)) {
                    if (neighbor == source) {
                        return true;
                    }
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            return false;
        }
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(source);
        visited[source] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (neighbor == destination) {
                    return true;
                }
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int p = 0; p < t; p++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph.get(u).add(v);
            }
            
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            
            RouteBetweenNodes solution = new RouteBetweenNodes();
            boolean result = solution.routeBetweenNodes(src, dest, n, graph);
            System.out.println(result ? "yes" : "no");
        }
        
        scanner.close();
    }
}
