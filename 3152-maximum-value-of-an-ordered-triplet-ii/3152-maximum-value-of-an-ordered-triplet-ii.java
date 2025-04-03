class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0; 

        int mp = nums[0];
        int md = Integer.MIN_VALUE;
        long result = 0;

        for (int j = 1; j < n - 1; j++) {
            md = Math.max(md, mp - nums[j]);
            result = Math.max(result, (long) md * nums[j + 1]);
            mp = Math.max(mp, nums[j]);
        }

        return result;
    }
}