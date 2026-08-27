class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return -1;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int min = Integer.MAX_VALUE;

        for (List<Integer> list : map.values()) {
            Collections.sort(list);

            if (list.size() >= 3) {

                for (int i = 0; i <= list.size() - 3; i++) {
                    int a = list.get(i);
                    int b = list.get(i + 1);
                    int c = list.get(i + 2);

                    int val = 2 * (c - a);
                    min = Math.min(min, val);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}