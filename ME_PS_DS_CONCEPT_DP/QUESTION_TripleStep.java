import java.util.*;

class TripleStep {
    static final int MOD = 1000000007;

    int numberOfWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: One way to stand still (do nothing)
        dp[1] = 1; // Base case: One way to take one step
        dp[2] = 2; // Base case: Two ways to reach the second step (1+1, 2)

        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TripleStep tripleStep = new TripleStep();
        int result = tripleStep.numberOfWays(n);
        System.out.println(result);
        scanner.close();
    }
}
