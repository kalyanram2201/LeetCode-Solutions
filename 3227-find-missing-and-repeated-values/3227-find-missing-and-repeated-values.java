import java.util.HashMap;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        
        for (int i = 1; i <= n * n; i++) {
            if (!map.containsKey(i)) {
                result[1] = i;  
            } else if (map.get(i) == 2) {
                result[0] = i; 
            }
        }

        return result;
    }
}
