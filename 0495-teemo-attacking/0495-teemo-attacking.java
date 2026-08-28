class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int n = timeSeries.length;
        for (int i = 1; i < n; i++) {
            int gap = timeSeries[i] - timeSeries[i - 1];
            result += Math.min(gap, duration);
        }
        return result + duration;
    }
}