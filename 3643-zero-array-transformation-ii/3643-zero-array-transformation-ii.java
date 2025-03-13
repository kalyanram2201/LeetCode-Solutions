import java.util.*;

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        
        int low = 0, high = m, result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormZeroArray(mid, nums, queries, n)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }

    private boolean canFormZeroArray(int k, int[] nums, int[][] queries, int n) {
        int[] diff = new int[n + 1];
        int[] temp = Arrays.copyOf(nums, n);
        int sum = 0;
        
        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[l] += val;
            if (r + 1 < n) diff[r + 1] -= val;
        }
        
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (temp[i] - sum > 0) {
                return false;
            }
        }
        return true;
    }
}
