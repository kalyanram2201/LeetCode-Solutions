class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans[] = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < nums.get(i); j++) {
                if ((j | (j + 1)) == nums.get(i)) {
                    min = Math.min(j, min);
                }
            }

            ans[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return ans;
    }
}
