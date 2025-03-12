import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        List<Integer> result = new ArrayList<>();
        
        int first = binarySearchFirst(nums, target);
        
        if (first == -1) return result; // Target not found
        
        // Collect all indices where nums[i] == target
        for (int i = first; i < nums.length && nums[i] == target; i++) {
            result.add(i);
        }
        
        return result;
    }

    private int binarySearchFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, firstIndex = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                firstIndex = mid;
                right = mid - 1; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return firstIndex;
    }
}
