class Solution {
    int values[] = { 1, 2, 145, 40585 };

    public boolean isDigitorialPermutation(int n) {
        int[] freq = getFreq(n);

        for (int f : values) {
            if (sameDigits(freq, getFreq(f))) {
                return true;
            }
        }

        return false;
    }

    private int[] getFreq(int num) {
        int[] freq = new int[10];
        if (num == 0)
            freq[0]++;

        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }

        return freq;
    }

    private boolean sameDigits(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}