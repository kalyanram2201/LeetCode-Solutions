class Solution {
    public int[] evenOddBit(int n) {
        if (n == 0)
            return new int[] { 0, 0 };

        StringBuilder sc = new StringBuilder();
        while (n > 0) {
            sc.append(n % 2);
            n = n / 2;
        }

        int even = 0, odd = 0;
        for (int i = 0; i < sc.length(); i++) {
            if (sc.charAt(i) == '1') {
                if (i % 2 == 0)
                    even++;
                else
                    odd++;
            }
        }

        return new int[] { even, odd };
    }
}
