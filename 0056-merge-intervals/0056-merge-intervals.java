import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                result.add(temp);
                temp = intervals[i];
            }
        }

        result.add(temp);
        return result.toArray(new int[result.size()][]);
    }
}
