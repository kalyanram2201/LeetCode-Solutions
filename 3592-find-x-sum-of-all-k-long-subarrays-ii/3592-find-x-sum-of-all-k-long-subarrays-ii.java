class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        TreeMap<int[], Integer> top = new TreeMap<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });

        TreeMap<int[], Integer> rest = new TreeMap<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });

        long sumTop = 0;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int count = freq.getOrDefault(num, 0);
            if (count > 0) {
                int[] old = new int[]{count, num};
                if (top.containsKey(old)) {
                    sumTop -= (long) old[0] * old[1];
                    removeOne(top, old);
                } else removeOne(rest, old);
            }

            count++;
            freq.put(num, count);
            int[] now = new int[]{count, num};
            top.put(now, top.getOrDefault(now, 0) + 1);
            sumTop += (long) count * num;

            if (top.size() > x) {
                int[] smallest = top.lastKey();
                sumTop -= (long) smallest[0] * smallest[1];
                moveOne(top, rest, smallest);
            }

            if (i >= k) {
                int rem = nums[i - k];
                int oldCount = freq.get(rem);
                int[] old = new int[]{oldCount, rem};
                if (top.containsKey(old)) {
                    sumTop -= (long) oldCount * rem;
                    removeOne(top, old);
                } else removeOne(rest, old);

                if (oldCount == 1) freq.remove(rem);
                else {
                    oldCount--;
                    freq.put(rem, oldCount);
                    int[] updated = new int[]{oldCount, rem};
                    rest.put(updated, rest.getOrDefault(updated, 0) + 1);
                }

                if (top.size() < x && !rest.isEmpty()) {
                    int[] best = rest.firstKey();
                    moveOne(rest, top, best);
                    sumTop += (long) best[0] * best[1];
                }
            }

            if (i >= k - 1) ans[i - k + 1] = sumTop;
        }

        return ans;
    }

    void removeOne(TreeMap<int[], Integer> map, int[] key) {
        int c = map.get(key);
        if (c == 1) map.remove(key);
        else map.put(key, c - 1);
    }

    void moveOne(TreeMap<int[], Integer> from, TreeMap<int[], Integer> to, int[] key) {
        removeOne(from, key);
        to.put(key, to.getOrDefault(key, 0) + 1);
    }

}
