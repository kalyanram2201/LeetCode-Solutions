class Solution {

    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int res = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0)
                continue;

            if (isSortable(nums, sorted, n, k)) {
                res += k;
            }
        }

        return res;
    }

    public boolean isSortable(int[] nums, int[] sorted, int n, int k) {
        for (int i = 0; i < n; i += k) {

            Map<Integer, Integer> hm = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                hm.merge(nums[j], 1, Integer::sum);
                hm.merge(sorted[j], -1, Integer::sum);
            }

            for (int val : hm.values()) {
                if (val != 0) {
                    return false;
                }
            }

            int[] chunk = Arrays.copyOfRange(nums, i, i + k);
            int[] sortedChunk = Arrays.copyOfRange(sorted, i, i + k);

            if (!isCyclicRotationKMP(chunk, sortedChunk)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclicRotationKMP(int[] chunk, int[] sortedChunk) {
        int k = chunk.length;

        int[] fail = new int[k];
        fail[0] = 0;

        for (int i = 1; i < k; i++) {
            int j = fail[i - 1];

            while (j > 0 && sortedChunk[i] != sortedChunk[j]) {
                j = fail[j - 1];
            }

            if (sortedChunk[i] == sortedChunk[j]) {
                fail[i] = j + 1;
            } else {
                fail[i] = 0;
            }
        }

        int matched = 0;

        for (int i = 0; i < 2 * k; i++) {
            int c = chunk[i % k];

            while (matched > 0 && c != sortedChunk[matched]) {
                matched = fail[matched - 1];
            }

            if (c == sortedChunk[matched]) {
                matched++;
            }

            if (matched == k) {
                return true;
            }
        }

        return false;
    }
}