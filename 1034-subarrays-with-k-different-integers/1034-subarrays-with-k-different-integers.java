import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0, result = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 1)
                k--;

            while (k < 0) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0)
                    k++;
                j++;
            }

            result += i - j + 1;
        }

        return result;
    }
}
