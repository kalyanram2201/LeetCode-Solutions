class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> map = new HashMap<>();
        
        for (int[] rect : rectangles) {
            double ratio = (double) rect[0] / rect[1];
            map.put(ratio, map.getOrDefault(ratio, 0L) + 1);
        }

        long count = 0;
        for (long val : map.values()) {
            count += val * (val - 1) / 2;
        }
        return count;
    }
}
