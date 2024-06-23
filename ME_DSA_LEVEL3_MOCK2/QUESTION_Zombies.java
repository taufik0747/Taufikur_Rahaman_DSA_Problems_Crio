import java.util.*;

class Zombies {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            
            System.out.println(zombies(grid, n, m));
            t--;
        }
        
        sc.close();
    }
    
    static int zombies(int[][] grid, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        int totalNonEmptyHouses = 0;
        int infectedHouses = 0;
        
        // Initialize the queue with all initially infected houses and count non-empty houses
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] != 0) {
                    totalNonEmptyHouses++;
                }
            }
        }
        
        // If there are no non-empty houses or all are already infected
        if (totalNonEmptyHouses == 0) return 0;
        if (queue.size() == totalNonEmptyHouses) return 0;
        
        // Directions array for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean newInfections = false;
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        newInfections = true;
                    }
                }
            }
            
            if (newInfections) {
                minutes++;
            }
            
            infectedHouses += size;
            
            // If all non-empty houses are infected
            if (infectedHouses == totalNonEmptyHouses) {
                return minutes;
            }
        }
        
        // If not all non-empty houses are infected
        return -1;
    }
}
