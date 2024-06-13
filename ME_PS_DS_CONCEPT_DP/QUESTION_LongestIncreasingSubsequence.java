import java.util.*;

class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of integers in the list
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // Read each integer into the array
        }
        System.out.println(longestIncreasingSubsequence(arr));
        sc.close();
    }

    private static int longestIncreasingSubsequence(int[] arr) {
        if (arr.length == 0) return 0;
        
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);  // Initialize all dp values to 1
        int maxLen = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
