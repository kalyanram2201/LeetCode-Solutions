class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        long[] time = new long[n + 1];

        for (int j = 0; j < mana.length; j++) {
            for (int i = 0; i < n; i++) {
                time[i + 1] = Math.max(time[i], time[i + 1]) + (long) mana[j] * skill[i];
            }
            for (int i = n - 1; i > 0; i--) {
                time[i] = time[i + 1] - (long) mana[j] * skill[i];
            }
        }
        return time[n];
    }

}
