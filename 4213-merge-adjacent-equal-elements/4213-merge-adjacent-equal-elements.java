class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n = nums.length;
        List<Long> list = new ArrayList<>();

        for (int num : nums) {
            long val = num;
            while (!list.isEmpty() && list.get(list.size() - 1) == val) {
                val += list.remove(list.size() - 1);
            }
            list.add(val);
        }
        return list;
    }
}
