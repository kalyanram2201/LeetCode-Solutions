class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            String temp=Arrays.toString(row);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        int n = grid.length, count = 0;
        
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = grid[j][i];
            }
            count += map.getOrDefault(Arrays.toString(temp), 0);
        }
        
        return count;
    }
}
