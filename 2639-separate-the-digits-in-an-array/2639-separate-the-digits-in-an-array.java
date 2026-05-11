class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            List<Integer> list = new ArrayList<>();
            while (num > 0) {
                list.add(num % 10);
                num = num / 10;
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                result.add(list.get(i));
            }
        }
        int ans[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}