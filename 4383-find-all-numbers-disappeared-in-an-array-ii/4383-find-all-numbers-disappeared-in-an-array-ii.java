class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {

        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, true);
        }

        List<List<Integer>> res = new ArrayList<>();

        int first = -1;
        boolean set = false;

        for (int i = lower; i <= upper; i++) {

            if (!map.getOrDefault(i, false) && !set) {
                first = i;
                set = true;
            } else if (map.getOrDefault(i, false) && set) {
                List<Integer> list = new ArrayList<>();
                list.add(first);
                list.add(i - 1);

                res.add(list);
                first = -1;
                set = false;
            }
        }

        if (set) {
            List<Integer> list = new ArrayList<>();
            list.add(first);
            list.add(upper);
            res.add(list);
        }

        return res;
    }
}