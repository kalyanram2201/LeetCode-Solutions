import java.util.*;

class Solution {
    public int maxSubstrings(String s) {
        List<int[]> candidates = new ArrayList<>();

        int n = s.length();
       
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 3; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    candidates.add(new int[]{i, j});
                    break; 
                }
            }
        }

        candidates.sort((a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEnd = -1;

        for (int[] interval : candidates) {
            int start = interval[0], end = interval[1];
            if (start > lastEnd) {
                count++;
                lastEnd = end;
            }
        }

        return count;
    }
}