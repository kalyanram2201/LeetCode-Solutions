class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = 0, min = 10001;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[max + 1];
        for (int i : nums) {
            arr[i]++;
        }
        for (int i = min; i < max; i++) {
            if (arr[i] == 0)
                res.add(i);
        }
        return res;
    }
}