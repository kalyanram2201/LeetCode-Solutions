class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int result[] = new int[1000];
        int res = 0;
        for (int[] temp : dominoes) {
            int val1 = temp[0], val2 = temp[1];
            int key = Math.min(val1, val2) * 10 + Math.max(val1, val2);
            res += result[key];
            result[key]++;

        }
        return res;

    }
}