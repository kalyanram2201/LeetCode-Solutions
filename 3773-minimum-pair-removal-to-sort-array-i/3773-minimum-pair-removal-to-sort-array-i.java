class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count = 0;

        while (!sorted(nums)) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < min) {
                    min = sum;
                    index = i;
                }
            }

            if (index != -1) {
                nums[index] = min;

                for (int i = index + 1; i < nums.length - 1; i++) {
                    nums[i] = nums[i + 1];
                }

                nums = Arrays.copyOf(nums, nums.length - 1);
                count++;
            }
        }

        return count;
    }

    private boolean sorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}