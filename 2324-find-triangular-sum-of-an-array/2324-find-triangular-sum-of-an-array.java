import java.util.*;

class Solution {
    public int triangularSum(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);

        while (arr.length > 1) {
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                newArr[i] = (arr[i] + arr[i + 1]) % 10;
            }
            arr = newArr;
        }

        return arr[0];
    }
}
