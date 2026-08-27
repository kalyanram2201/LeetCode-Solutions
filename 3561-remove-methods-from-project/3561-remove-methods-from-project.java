import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visit = new boolean[n];
        Set<Integer> suspicious = new HashSet<>();

        dfs(k, adj, visit, suspicious);
        
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious.contains(u) && suspicious.contains(v)) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visit, Set<Integer> suspicious) {
        visit[node] = true;
        suspicious.add(node);

        for (int next : adj.get(node)) {
            if (!visit[next]) {
                dfs(next, adj, visit, suspicious);
            }
        }
    }
}