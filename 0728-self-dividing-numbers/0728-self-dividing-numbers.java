class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (i < 10)
                res.add(i);
            else if (selfD(i)) {
                res.add(i);
            }
        }
        return res;
    }

    boolean selfD(int x) {
        int temp = x;
        while (temp > 0) {
            int rem = temp % 10;
            if (rem == 0 || x % rem != 0)
                return false;
            temp /= 10;
        }
        return true;
    }
}