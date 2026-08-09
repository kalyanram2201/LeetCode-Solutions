class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            graph[parent[i]].add(i);
        }

        int[] depth = new int[n];
        int height = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        depth[0] = 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            height = Math.max(height, depth[u]);

            for (int v : graph[u]) {
                depth[v] = depth[u] + 1;
                q.offer(v);
            }
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += 1L * nums[i] * (height - depth[i] + 1);
        }

        return ans;
    }
}