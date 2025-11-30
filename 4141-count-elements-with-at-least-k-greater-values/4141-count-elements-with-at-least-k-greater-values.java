class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int res = 0;
        for (int num : nums) {
            int gre = n - helper(sorted, num);
            if (gre >= k)
                res++;
        }
        return res;
    }

    int helper(int[] arr, int t) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] <= t)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
}