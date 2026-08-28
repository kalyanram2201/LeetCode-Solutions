class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];
        int n = nums.length;
        for (int num : nums) {
            freq[num]++;
        }

        int max = 0;
        for (int val : freq) {
            max = Math.max(val, max);
        }

        int count = 0;
        for (int num : nums) {
            if (freq[num] == max) {
                count++;
            }
        }
        return count;

    }
}