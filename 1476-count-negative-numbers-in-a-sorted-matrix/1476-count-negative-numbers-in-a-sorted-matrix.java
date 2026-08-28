class Solution {
    public int countNegatives(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }

        int count = 0;
        for (int[] num : grid) {
            for (int val : num) {
                if (val < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}