import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int freeDays = 0, lastEnd = 0;

        for (int[] meet : meetings) {
            if (meet[0] > lastEnd + 1) {
                freeDays += meet[0] - lastEnd - 1;
            }
            lastEnd = Math.max(lastEnd, meet[1]);
        }

        if (lastEnd < days) {
            freeDays += days - lastEnd;
        }

        return freeDays;
    }
}
