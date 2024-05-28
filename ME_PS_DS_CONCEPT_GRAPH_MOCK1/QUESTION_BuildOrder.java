import java.util.*;

public class BuildOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine();  // Consume the newline after integers

        String[] projects = sc.nextLine().split(" ");
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        for (String project : projects) {
            adjList.put(project, new ArrayList<>());
            inDegree.put(project, 0);
        }

        for (int i = 0; i < d; i++) {
            String p = sc.next();
            String q = sc.next();
            adjList.get(p).add(q);
            inDegree.put(q, inDegree.get(q) + 1);
        }
        sc.close();

        List<String> order = findBuildOrder(projects, adjList, inDegree);
        if (order == null) {
            System.out.println(-1);
        } else {
            for (String proj : order) {
                System.out.print(proj + " ");
            }
        }
    }

    private static List<String> findBuildOrder(String[] projects, Map<String, List<String>> adjList, Map<String, Integer> inDegree) {
        Queue<String> queue = new LinkedList<>();
        for (String project : projects) {
            if (inDegree.get(project) == 0) {
                queue.add(project);
            }
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String project = queue.poll();
            result.add(project);

            for (String dep : adjList.get(project)) {
                inDegree.put(dep, inDegree.get(dep) - 1);
                if (inDegree.get(dep) == 0) {
                    queue.add(dep);
                }
            }
        }

        if (result.size() != projects.length) {
            return null;  // Cycle detected
        }

        return result;
    }
}
