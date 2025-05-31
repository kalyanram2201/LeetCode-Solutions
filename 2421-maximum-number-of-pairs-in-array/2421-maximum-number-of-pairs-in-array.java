class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int pair = 0, lo = 0;
        for (int value : map.values()) {
            pair += value / 2;
            lo += value % 2;
        }

        return new int[]{pair, lo};
    }
}
