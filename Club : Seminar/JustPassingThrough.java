import java.util.Arrays;
import java.util.Scanner;

public class JustPassingThrough {
    
    private final static int INFINITY = 500001;
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        // Input
        int r = scan.nextInt();
        int c = scan.nextInt();
        int n = scan.nextInt();
        
        int[][] map = new int[r][c];
        int[][] passes = new int[r][c];
        int[][][] memo = new int[r][c][n + 1];
        int min = INFINITY;
        
        // Taking input and setting memo table to infinity
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = scan.nextInt();
                Arrays.fill(memo[i][j], INFINITY);
            }
        }
        
        // Preprocessing: Pass table
        for (int i = 1; i < r - 1; i++) {
            for (int j = 1; j < c - 1; j++) {
                passes[i][j] = isPass(map, i, j);
            }
        }
        
        // Top down dp
        for (int i = 0; i < r; i++) {
            min = map[i][0] != -1 ? Math.min(min, dfs(map, memo, passes, i, 0, n)) : min;
        }
        
        System.out.println(min >= INFINITY ? "impossible" : min);
    }
    
    public static int dfs(int[][] map, int[][][] memo, int[][] passTable, int r, int c, int n) {
        
        // Base Cases
        if (map[r][c] == -1 || n < 0) return INFINITY;
        
        // Column is at West edge
        if (c == map[0].length - 1) {
            if (n == 0) return memo[r][c][n] = map[r][c];
            else return INFINITY;
        }
        
        // Found in memo table
        if (memo[r][c][n] != INFINITY) return memo[r][c][n];
        
        // Dfs step
        int east = c + 1 < map[0].length ? dfs(map, memo, passTable, r, c + 1, n - passTable[r][c + 1]) + map[r][c] : INFINITY;
        int nEast = c + 1 < map[0].length && r - 1 > -1 ? dfs(map, memo, passTable, r - 1, c + 1, n - passTable[r - 1][c + 1]) + map[r][c] : INFINITY;
        int sEast = c + 1 < map[0].length && r + 1 < map.length ? dfs(map, memo, passTable, r + 1, c + 1, n - passTable[r + 1][c + 1]) + map[r][c] : INFINITY;
        
        return memo[r][c][n] = Math.min(east, Math.min(nEast, sEast));
    }
    
    public static int isPass(int[][] map, int r, int c) {
        if (map[r - 1][c] == -1 || map[r + 1][c] == -1 || map[r][c - 1] == -1 || map[r][c + 1] == -1) return 0;
        if (map[r][c] < map[r - 1][c] && map[r][c] < map[r + 1][c] && map[r][c] > map[r][c - 1] && map[r][c] > map[r][c + 1]) return 1;
        return 0;
    }
}