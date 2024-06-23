import java.util.*;

class NetworkDelayTime {

    public static int networkDelayTime(int N, ArrayList<ArrayList<Integer>> edges, int K) {
        // Create a graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (ArrayList<Integer> edge : edges) {
            graph.putIfAbsent(edge.get(0), new ArrayList<>());
            graph.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
        }

        // Map to store minimum time to reach each node
        Map<Integer, Integer> dist = new HashMap<>();
        for (int node = 1; node <= N; node++) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(K, 0);

        // Priority queue to process nodes in increasing order of their shortest known distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(info -> info[1]));
        pq.add(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int node = info[0];
            int time = info[1];

            if (time > dist.get(node)) {
                continue;
            }

            // Process all adjacent nodes
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int neighbour = edge[0];
                    int d = edge[1];
                    if (time + d < dist.get(neighbour)) {
                        pq.offer(new int[]{neighbour, time + d});
                        dist.put(neighbour, time + d);
                    }
                }
            }
        }

        // Find the maximum time from K to all other nodes
        int maxWait = Collections.max(dist.values());
        return maxWait == Integer.MAX_VALUE ? -1 : maxWait;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(sc.nextInt());  // source
            edge.add(sc.nextInt());  // target
            edge.add(sc.nextInt());  // time
            edges.add(edge);
        }

        int k = sc.nextInt();
        int answer = networkDelayTime(n, edges, k);

        System.out.println(answer);
        sc.close();
    }
}
