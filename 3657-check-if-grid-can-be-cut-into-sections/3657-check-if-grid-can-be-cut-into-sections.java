import java.util.Arrays;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return countLines(rectangles, 0) || countLines(rectangles, 1);
    }

    private boolean countLines(int[][] rectangles, int axis) {
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[axis], b[axis]));
        int lineCount = 1, end = rectangles[0][axis + 2];

        for (int[] rect : rectangles) {
            if (rect[axis] >= end) {
                lineCount++;
                end = rect[axis + 2];
            } else {
                end = Math.max(end, rect[axis + 2]);
            }
        }
        return lineCount >= 3;
    }
}
