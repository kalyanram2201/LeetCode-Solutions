import java.util.*;

class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + capacity[i];
        long ans = 0;
        Map<String, Long> map = new HashMap<>();
        for (int r = 2; r < n; r++) {
            int l = r - 2;
            String storeKey = capacity[l] + "#" + (prefix[l + 1] + capacity[l]);
            map.put(storeKey, map.getOrDefault(storeKey, 0L) + 1);

            String queryKey = capacity[r] + "#" + prefix[r];
            ans += map.getOrDefault(queryKey, 0L);
        }

        return ans;
    }
}
