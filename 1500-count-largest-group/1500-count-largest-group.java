class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
        }

        int count = 0;
        for (int val : map.values()) {
            if (val == max)
                count++;
        }

        return count;
    }

    int digitSum(int n) {
        int sum = 0;
        
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}