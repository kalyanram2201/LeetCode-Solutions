class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int odd = 0, even = 0;

            if (nums[i] % 2 == 0)
                even++;
            else
                odd++;

            if (odd != 0 && 1L * even * b <= 1L * odd * a)
                count++;

            for (int j = i + 1; j < n; j++) {

                if (nums[j] % 2 == 0)
                    even++;
                else
                    odd++;

                if (odd != 0 && 1L * even * b <= 1L * odd * a)
                    count++;
            }
        }

        return count;
    }
}