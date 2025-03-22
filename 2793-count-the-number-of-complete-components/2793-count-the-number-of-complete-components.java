import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int[] node = new int[1], edge = new int[1];
                dfs(i, node, edge, list, visit);
                if (edge[0] / 2 == node[0] * (node[0] - 1) / 2) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int[] node, int[] edge, List<List<Integer>> list, boolean[] visit) {
        node[0]++;
        visit[i] = true;
        for (int val : list.get(i)) {
            edge[0]++;
            if (!visit[val]) {
                dfs(val, node, edge, list, visit);
            }
        }
    }
}
