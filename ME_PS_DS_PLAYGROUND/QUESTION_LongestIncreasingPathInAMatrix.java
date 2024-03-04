import java.util.Scanner;

public class LongestIncreasingPathInAMatrix {
    private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int dfs(int[][] matrix, int[][] cache, int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length
                && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(matrix, cache, x, y);
                max = Math.max(max, len);
            }
        }
        cache[i][j] = max;
        return max;
    }

    public static int longestIncreasingPathInAMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, cache, i, j);
                max = Math.max(max, len);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(longestIncreasingPathInAMatrix(matrix));
        sc.close();
    }
}
