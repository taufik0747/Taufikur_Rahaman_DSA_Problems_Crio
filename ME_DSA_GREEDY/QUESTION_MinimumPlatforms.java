import java.util.*;

class MinimumPlatforms {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrival = new int[n];
        int[] departure = new int[n];

        for (int i = 0; i < n; i++) {
            arrival[i] = sc.nextInt();
            departure[i] = sc.nextInt();
        }

        System.out.println(minimumPlatforms(n, arrival, departure));
    }

    static int minimumPlatforms(int n, int[] arrival, int[] departure) {
        // Create an event list with all arrival and departure times
        int[][] events = new int[2 * n][2];  // [time, event type] (event type: 1 for arrival, -1 for departure)

        for (int i = 0; i < n; i++) {
            events[2 * i] = new int[]{arrival[i], 1};        // Arrival events
            events[2 * i + 1] = new int[]{departure[i], -1}; // Departure events
        }

        // Sort events: earlier times first, and for the same time, arrivals before departures
        Arrays.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Prioritize arrivals (1) over departures (-1)
            }
            return a[0] - b[0];
        });

        int currentPlatforms = 0;
        int maxPlatforms = 0;

        // Traverse sorted events to determine the number of platforms needed
        for (int[] event : events) {
            if (event[1] == 1) {  // Arrival increases the need for a platform
                currentPlatforms++;
            } else {  // Departure frees up a platform
                currentPlatforms--;
            }
            maxPlatforms = Math.max(maxPlatforms, currentPlatforms);
        }

        return maxPlatforms;
    }
}
