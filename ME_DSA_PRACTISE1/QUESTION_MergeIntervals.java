import java.util.*;

public class MergeIntervals {

    class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0]; // Sort by start time
        }
    }

    public int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort the intervals based on the start time
        Arrays.sort(intervals, new IntervalComparator());

        // 2. Merge intervals
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) { // Overlapping intervals
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // Non-overlapping interval, move to the next interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        MergeIntervals solution = new MergeIntervals();
        int[][] result = solution.mergeIntervals(intervals);

        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        scanner.close();
    }
}
