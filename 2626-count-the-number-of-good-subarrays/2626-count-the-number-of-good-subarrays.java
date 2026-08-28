class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long pair = 0;
        long goodSubarrays = 0;

        for (int right = 0; right < nums.length; right++) {
            int count = freq.getOrDefault(nums[right], 0);
            pair += count;
            freq.put(nums[right], count + 1);

            while (pair >= k) {
                goodSubarrays += nums.length - right;
                int leftNum = nums[left++];
                int f = freq.get(leftNum);
                freq.put(leftNum, f - 1);
                pair -= (f - 1);
            }
        }

        return goodSubarrays;
    }
}