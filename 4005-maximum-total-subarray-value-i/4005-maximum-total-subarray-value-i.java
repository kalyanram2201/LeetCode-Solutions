class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return (long)(max - min) * k;
    }
}