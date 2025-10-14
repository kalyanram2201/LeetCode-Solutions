class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if (k - 1 == 0)
            return true;
        int exist = k - 1;
        for (int i = k + 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1) && nums.get(i - k) > nums.get(i - k - 1)) {
                exist--;
            } else {
                exist = k - 1;
            }
            if (exist == 0)
                return true;
        }
        return false;
    }
}