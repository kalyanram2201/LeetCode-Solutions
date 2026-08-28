class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int mod = (int) 1e9;
        int[][] dist = new int[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], mod);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (dist[j][i] < mod && dist[i][k] < mod) {
                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    }
                }
            }
        }

        long total = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if (dist[s][t] == mod) {
                return -1;
            }
            total += dist[s][t];
        }
        return total;
    }
}