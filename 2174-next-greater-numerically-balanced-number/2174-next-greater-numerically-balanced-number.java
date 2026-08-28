class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1666666; i++) {
            if (isBalanced(i)) {
                return i;
            }
        }
        return -1;
    }

    boolean isBalanced(int n) {
        int count[] = new int[10];
        int num = n;
        while (num > 0) {
            int rem = num % 10;
            count[rem]++;
            num /= 10;
        }

        if (count[0] > 0)
            return false;

        for (int i = 1; i <= 9; i++) {
            if (count[i] > 0 && count[i] != i) {
                return false;
            }
        }
        return true;
    }
}
