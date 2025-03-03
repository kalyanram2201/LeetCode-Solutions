class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int evenCount = (nums.length + 1) / 2;
        int oddCount = nums.length / 2;

        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];

        int j = 0, k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[j++] = nums[i];
            } else {
                odd[k++] = nums[i];
            }
        }

        Arrays.sort(even);

        Arrays.sort(odd);
        for (int i = 0; i < odd.length / 2; i++) {
            int temp = odd[i];
            odd[i] = odd[odd.length - 1 - i];
            odd[odd.length - 1 - i] = temp;
        }

        j = k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = even[j++];
            } else {
                nums[i] = odd[k++];
            }
        }

        return nums;
    }
}