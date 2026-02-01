class Solution {
    public int countMonobit(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                count++;
                continue;
            }
            if (i % 2 == 0)
                continue;
            if (valid(i)) {
                count++;
            }
        }
        return count;
    }

    boolean valid(int k) {
        Set<Integer> set = new HashSet<>();
        while (k > 0) {
            int rem = k % 2;
            k = k / 2;
            set.add(rem);
            if (set.size() > 1)
                return false;
        }
        return true;
    }
}