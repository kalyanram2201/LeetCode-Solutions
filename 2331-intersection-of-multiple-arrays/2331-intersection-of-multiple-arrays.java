class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();

        for (int v : nums[0]) {
            set1.add(v);
        }

        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int[] temp = nums[i];
            Set<Integer> set2 = new HashSet<>();
            for (int v : temp) {
                set2.add(v);
            }
            set1.retainAll(set2);
        }

        result.addAll(set1);
        Collections.sort(result);
        return result;
    }
}
