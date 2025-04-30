class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length, even = 0;
        for (int num : nums) {
            int count = 0;
            while (num > 0) {
                count++;
                num = num / 10;
            }
            if (count % 2 == 0)
                even++;
        }
        return even;
    }
}