class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int rev = reverse(nums[i]);

            if (!map.containsKey(rev))
                continue;

            List<Integer> list = map.get(rev);

            int pos = upperBound(list, i);

            if (pos < list.size()) {
                ans = Math.min(ans, list.get(pos) - i);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int reverse(int x) {
        int res = 0;
        while (x > 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
    }

    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (list.get(m) <= target)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}