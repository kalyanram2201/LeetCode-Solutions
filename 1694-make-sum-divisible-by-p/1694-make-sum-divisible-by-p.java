class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums)
            sum += num;

        long rem = sum % p;
        if (rem == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0, res = n;

        for (int i = 0; i < n; i++) {
            prefix = (prefix + nums[i]) % p;

            int need = (prefix - (int) rem + p) % p;

            if (map.containsKey(need))
                res = Math.min(res, i - map.get(need));

            map.put(prefix, i);
        }

        return res == n ? -1 : res;
    }
}
