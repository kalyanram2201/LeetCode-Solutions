class Solution {
    public int[] getConcatenation(int[] nums) {
        int ans[] = new int[2 * nums.length], n = nums.length;
        int k = 0;
        for (int num : nums) {
            ans[k++] = num;
        }
        for (int num : nums) {
            ans[k++] = num;
        }
        return ans;
    }
}