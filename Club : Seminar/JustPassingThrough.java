import java.util.Scanner;

public class JustPassingThrough {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        // Input
        int r = scan.nextInt();
        int c = scan.nextInt();
        int n = scan.nextInt();
        
        int[][] map = new int[r][c];
        int[][] passes = new int[r][c];
        
        long[][][] memoMin = new long[r][c][n + 1];
        long min = Integer.MAX_VALUE;
        
        // Taking input and setting memo table to infinity
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = scan.nextInt();
                for (int k = 0; k < n + 1; k++) {
                    memoMin[i][j][k] = Integer.MAX_VALUE;
                } 
            }
        }
        
        // Preprocessing: Pass table
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                passes[i][j] = isPass(map, i, j);
            }
        }
        
        // Top down dp
        for (int i = 0; i < r; i++) {
            if (map[i][0] != -1) {
                min = Math.min(min, dfs(map, memoMin, passes, i, 0, n, 0));
            }
        }
        
        if (min >= Integer.MAX_VALUE) System.out.println("impossible");
        else System.out.println(min);
    }
    
    public static long dfs(int[][] map, long[][][] memoMin, int[][] passMemo, int r, int c, int n, int passes) {
        
        // Base Cases
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) return Integer.MAX_VALUE;
        
        if (map[r][c] == -1) return Integer.MAX_VALUE;
        
        passes += passMemo[r][c];
        
        if (passes > n) return Integer.MAX_VALUE;
        
        // We get to end
        if (c == map[0].length - 1) {
            if (passes == n) return memoMin[r][c][passes] = map[r][c];
            else return Integer.MAX_VALUE;
        }
        
        // Found in memo
        if (memoMin[r][c][passes] != Integer.MAX_VALUE) return memoMin[r][c][passes];
        
        // Dfs step
        long east = dfs(map, memoMin, passMemo, r, c + 1, n, passes) + map[r][c];
        long nEast = dfs(map, memoMin, passMemo, r - 1, c + 1, n, passes) + map[r][c];
        long sEast = dfs(map, memoMin, passMemo, r + 1, c + 1, n, passes) + map[r][c];
        
        return memoMin[r][c][passes] = Math.min(east, Math.min(nEast, sEast));
    }
    
    public static int isPass(int[][] map, int r, int c) {
        
        if (r - 1 < 0 || r + 1 >= map.length || c - 1 < 0 || c + 1 >= map[0].length || map[r][c] == -1) return 0;
        
        if (map[r - 1][c] == -1 || map[r + 1][c] == -1 || map[r][c - 1] == -1 || map[r][c + 1] == -1) return 0;
        
        if (map[r][c] < map[r - 1][c] && map[r][c] < map[r + 1][c] && map[r][c] > map[r][c - 1] && map[r][c] > map[r][c + 1]) return 1;
        
        return 0;
    }
}