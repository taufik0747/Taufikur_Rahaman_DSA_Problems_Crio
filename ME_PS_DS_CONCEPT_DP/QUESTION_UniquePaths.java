import java.io.*;
import java.util.*;

class UniquePaths {
    private static final int MOD = 1000000007;

    // Fast exponentiation to calculate base^exp % mod
    private static long modExp(long base, int exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    // Function to calculate modular multiplicative inverse
    private static long modInverse(long a, int mod) {
        return modExp(a, mod - 2, mod); // Fermat's Little Theorem
    }

    public int uniquePaths(int m, int n) {
       
        if (m == 1 || n == 1) {
            return 1;
        }
        int totalSteps = m + n - 2;
        int k = Math.min(m-1, n-1);
        long result = 1;

        for (int i = 1; i <= k; i++) {
            result = result * (totalSteps - k + i) % MOD;
            result = result * modInverse(i, MOD) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();

        UniquePaths solution = new UniquePaths();
        int result = solution.uniquePaths(m, n);
        System.out.println(result);
    }
}
