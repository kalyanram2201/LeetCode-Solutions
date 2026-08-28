class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int val = nums.get(i);
            if (val == 2) {
                ans[i] = -1;
                continue;
            }

            int t = 0, temp = val;
            while ((temp & 1) == 1) {
                t++;
                temp >>= 1;
            }
            ans[i] = val - (1 << (t - 1));
        }
        return ans;
    }
}