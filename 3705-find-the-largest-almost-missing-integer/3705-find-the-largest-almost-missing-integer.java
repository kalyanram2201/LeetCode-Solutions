class Solution {
    public int largestInteger(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2 && k == 2) {
            if (nums[0] == nums[1])
                return nums[0];
            else {
                return Math.max(nums[0], nums[1]);
            }
        } else if (nums.length == 2 && k == 1) {
            if (nums[0] == nums[1]) {
                return -1;
            }

            else {
                if (nums[0] > nums[1]) {
                    return nums[0];
                } else {
                    return nums[1];
                }
            }
        }
        if (k == nums.length) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        } else {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i <= nums.length - k; i++) {
                int x = 0;
                int j = i;
                while (x < k) {
                    if (map.containsKey(nums[j])) {
                        int freq = map.get(nums[j]);
                        freq++;
                        map.put(nums[j], freq);
                    } else {
                        map.put(nums[j], 1);
                    }
                    x++;
                    j++;
                }

            }
            int ans = -1;

            for (int t = 0; t < nums.length; t++) {

                if (map.get(nums[t]) == 1) {
                    ans = Math.max(ans, nums[t]);
                }
            }

            return ans;
        }
    }
}