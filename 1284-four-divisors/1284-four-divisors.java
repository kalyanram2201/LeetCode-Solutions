class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int count = 0, sum = 0;
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    if (i * i == num) {
                        count++;
                        sum += i;
                    } else {
                        count += 2;
                        sum += i;
                        sum += num / i;
                    }
                }
            }
            if (count == 4)
                result += sum;
        }
        return result;
    }
}