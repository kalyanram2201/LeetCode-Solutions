class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        for (int value : map.values()) {
            if (value > 1) {
                count += (value * (value - 1)) / 2;
            }
        }
        return count;
    }
}