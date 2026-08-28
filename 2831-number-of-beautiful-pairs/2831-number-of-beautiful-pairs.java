class Solution {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length, count = 0;

        for (int i = 0; i < n; i++) {
            int first = getFirstDigit(nums[i]);
            for (int j = i + 1; j < n; j++) {
                int last = nums[j] % 10;
                if (gcd(first, last) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    int getFirstDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
