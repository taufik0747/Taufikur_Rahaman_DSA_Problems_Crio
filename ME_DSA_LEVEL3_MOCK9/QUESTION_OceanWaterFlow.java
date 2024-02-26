
import java.util.*;

class OceanWaterFlow {
    // Directions array to simplify moving up, down, left, and right
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] heights = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[i][j] = sc.nextInt();
            }
        }
        int[][] ans = oceanWaterFlow(heights);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    static int[][] oceanWaterFlow(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) return new int[0][0];
        
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, 0, i);
            dfs(heights, atlantic, Integer.MIN_VALUE, m - 1, i);
        }

        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = pacific[i][j] && atlantic[i][j] ? 1 : 0;
            }
        }

        return answer;
    }

    static void dfs(int[][] heights, boolean[][] visited, int height, int x, int y) {
        int m = heights.length, n = heights[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || heights[x][y] < height)
            return;

        visited[x][y] = true;
        for (int[] dir : dirs) {
            dfs(heights, visited, heights[x][y], x + dir[0], y + dir[1]);
        }
    }
}
