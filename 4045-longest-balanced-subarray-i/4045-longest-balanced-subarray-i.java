class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int even = 0, odd = 0;
            Map<Integer, Boolean> evenMap = new HashMap<>();
            Map<Integer, Boolean> oddMap = new HashMap<>();

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0 && !evenMap.getOrDefault(nums[j], false)) {
                    even++;
                    evenMap.put(nums[j], true);
                } else if (nums[j] % 2 != 0 && !oddMap.getOrDefault(nums[j], false)) {
                    odd++;
                    oddMap.put(nums[j], true);
                }

                if (even == odd) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}