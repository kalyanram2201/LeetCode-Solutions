import java.util.*;

public class Solution {
    int n, m;
    int[][] moveTime;
    boolean[][] visited;
    int[][] bestTime;
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int ans = Integer.MAX_VALUE;

    public int minTimeToReach(int[][] moveTime) {
        this.moveTime = moveTime;
        n = moveTime.length;
        m = moveTime[0].length;

        visited = new boolean[n][m];
        bestTime = new int[n][m];
        for (int[] row : bestTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        helper(0, 0, 0);
        return ans;
    }

    void helper(int i, int j, int time) {
        if (time >= bestTime[i][j]) return;
        bestTime[i][j] = time;

        if (i == n - 1 && j == m - 1) {
            ans = Math.min(ans, time);
            return;
        }

        visited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                int wait = moveTime[x][y];
                int nextTime = time + 1;
                if (wait > nextTime - 1) {
                    nextTime = wait + 1;
                }
                helper(x, y, nextTime);
            }
        }
        visited[i][j] = false;
    }
}
