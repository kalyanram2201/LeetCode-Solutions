class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty())
                map.put(nums2[i], stack.peek());
            else
                map.put(nums2[i], -1);
            stack.push(nums2[i]);
        }

        int res[] = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}