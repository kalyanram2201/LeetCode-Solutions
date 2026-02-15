class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> mapv = new HashMap<>();
        for (int freq : map.values()) {
            mapv.put(freq, mapv.getOrDefault(freq, 0) + 1);
        }
        for (int num : nums) {
            int freq = map.get(num);
            if (mapv.get(freq) == 1) {
                return num;
            }
        }

        return -1;
    }
}