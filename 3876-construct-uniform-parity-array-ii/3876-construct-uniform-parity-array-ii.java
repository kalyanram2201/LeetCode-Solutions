class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int odd = 0, even = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            if (num % 2 == 0)
                even++;
            else
                odd++;
            min = Math.min(num, min);
        }
        if (even == n || odd == n)
            return true;
        if (min % 2 == 0 && even == n)
            return true;
        if (min % 2 != 0)
            return true;
        return false;
    }
}