class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        long mod = 1_000_000_007;

        for (int num : nums) {
            int val = num - rev(num);
            map.put(val, map.getOrDefault(val, 0L) + 1);
        }

        long count = 0;
        for (long val : map.values()) {
            count = (count + val * (val - 1) / 2) % mod;
        }

        return (int) count;
    }

    private int rev(int num) {
        int temp = 0;
        while (num != 0) {
            temp = temp * 10 + num % 10;
            num /= 10;
        }
        return temp;
    }
}
