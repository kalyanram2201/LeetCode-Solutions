class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        int min = Integer.MAX_VALUE;
        boolean found = false;

        for (int num : nums2) {
            if (set1.contains(num)) {
                min = Math.min(min, num);
                found = true;
            }
        }

        return found ? min : -1;
    }
}