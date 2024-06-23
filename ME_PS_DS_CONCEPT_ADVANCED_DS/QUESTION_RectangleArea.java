import java.util.*;

public class RectangleArea {

    static class Event {
        int x, y1, y2, type;

        public Event(int x, int y1, int y2, int type) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.type = type;
        }
    }

    static class SegmentTree {
        long[] tree, count;
        int[] yCoord;

        SegmentTree(int[] yCoord) {
            int len = yCoord.length;
            this.yCoord = yCoord;
            tree = new long[4 * len];
            count = new long[4 * len];
        }

        void update(int node, int start, int end, int l, int r, int val) {
            if (start > r || end < l) return;

            if (start >= l && end <= r) {
                count[node] += val;
            } else {
                int mid = (start + end) / 2;
                update(2 * node + 1, start, mid, l, r, val);
                update(2 * node + 2, mid + 1, end, l, r, val);
            }

            if (count[node] > 0) {
                tree[node] = yCoord[end + 1] - yCoord[start];
            } else if (start != end) {
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            } else {
                tree[node] = 0;
            }
        }

        long query() {
            return tree[0];
        }
    }

    public static long findArea(int n, int[][] rectangles) {
        Map<Integer, Integer> yMap = new HashMap<>();
        List<Event> events = new ArrayList<>();
        
        // Collect all y coordinates for compression
        for (int[] rec : rectangles) {
            yMap.putIfAbsent(rec[1], 0);
            yMap.putIfAbsent(rec[3], 0);
        }
        int index = 0;
        int[] sortedY = new int[yMap.size()];
        for (int y : yMap.keySet()) {
            sortedY[index++] = y;
        }
        Arrays.sort(sortedY);
        for (int i = 0; i < sortedY.length; i++) {
            yMap.put(sortedY[i], i);
        }

        // Create events
        for (int[] rec : rectangles) {
            int x1 = rec[0], y1 = rec[1], x2 = rec[2], y2 = rec[3];
            events.add(new Event(x1, y1, y2, 1));
            events.add(new Event(x2, y1, y2, -1));
        }

        // Sort events
        events.sort((e1, e2) -> e1.x != e2.x ? Integer.compare(e1.x, e2.x) : Integer.compare(e2.type, e1.type));

        // Process events
        SegmentTree st = new SegmentTree(sortedY);
        long totalArea = 0, prevX = -1;
        for (Event e : events) {
            if (prevX != -1 && e.x > prevX) {
                totalArea += (e.x - prevX) * st.query();
            }
            st.update(0, 0, sortedY.length - 2, yMap.get(e.y1), yMap.get(e.y2) - 1, e.type);
            prevX = e.x;
        }

        return totalArea % 1_000_000_007;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] rectangles = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                rectangles[i][j] = scanner.nextInt();
            }
        }
        System.out.println(findArea(n, rectangles));
        scanner.close();
    }
}
