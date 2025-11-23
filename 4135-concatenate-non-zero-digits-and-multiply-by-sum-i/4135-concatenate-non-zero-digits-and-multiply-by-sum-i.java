class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long pow = 1;
        int t = n;
        while (t > 0) {
            int d = t % 10;
            if (d != 0) {
                x = d * pow + x;
                pow *= 10;
            }
            t /= 10;
        }
        long sum = 0, y = x;
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum * x;
    }
}
