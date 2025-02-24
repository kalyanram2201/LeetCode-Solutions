class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxKadane = kadane(nums); // Case 1: Normal max subarray sum
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i]; 
        }

        int minKadane = kadane(nums);
        int maxCircular = totalSum + minKadane; 
        
        if (maxKadane < 0) return maxKadane;

        return Math.max(maxKadane, maxCircular);
    }

    private int kadane(int[] arr) {
        int maxSum = arr[0], curSum = arr[0];
        for (int i = 1; i < arr.length; i++) { 
            curSum = Math.max(arr[i], curSum + arr[i]); 
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
