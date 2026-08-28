class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int num : nums) {
            if (num >= 0) {
                list.add(num);
            }
        }
        if (list.size() == 0)
            return nums;
        k = k % list.size();
        Collections.rotate(list, -k);

        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i] >= 0) {
                nums[i] = list.get(j++);
            }
        }
        return nums;

    }
}