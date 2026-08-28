class Solution {
    public int countTrapezoids(int[][] points) {
        int mod = 1_000_000_007;

        Map<Integer, Long> map = new HashMap<>();
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0L) + 1);
        }

        List<Long> list = new ArrayList<>();
        for (long cnt : map.values()) {
            if (cnt >= 2) {
                long ways = (cnt * (cnt - 1) / 2) % mod;
                list.add(ways);
            }
        }

        long ans = 0, sum = 0;
        for (long v : list) {
            ans = (ans + (v * sum) % mod) % mod;
            sum = (sum + v) % mod;
        }

        return (int) ans;
    }
}
