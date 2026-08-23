class Solution {
    void addFactor(int num, Map<Integer, Integer> map) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    void removeFactors(int num, Map<Integer, Integer> map) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
                while (num % i == 0)
                    num /= i;
            }
        }
        if (num > 1) {
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) {
                map.remove(num);
            }
        }
    }

    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            addFactor(nums[right], map);
            while (map.size() > k) {
                removeFactors(nums[left], map);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}