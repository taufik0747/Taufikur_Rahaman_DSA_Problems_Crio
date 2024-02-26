import java.util.*;

class NonOverlappingIntervals {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        System.out.println(nonOverlappingIntervals(intervals));
    }

    static int nonOverlappingIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        // Sort the intervals based on their end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int count = 0; // Count of intervals to remove
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // This interval overlaps with the last interval in the solution set, so we count it for removal
                count++;
            } else {
                // This interval does not overlap, update the lastEnd to the end of this interval
                lastEnd = intervals[i][1];
            }
        }
        
        return count;
    }
}
