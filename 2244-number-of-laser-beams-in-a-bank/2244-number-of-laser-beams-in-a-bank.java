class Solution {
    public int numberOfBeams(String[] bank) {
        if (bank.length == 0)
            return 0;

        int result = 0, prev = devices(bank[0]);
        for (int i = 1; i < bank.length; i++) {
            int count = devices(bank[i]);

            if (count == 0)
                continue;

            result += count * prev;
            prev = count;
        }

        return result;
    }

    int devices(String row) {
        int count = 0;

        for (char ch : row.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }

        return count;
    }
}