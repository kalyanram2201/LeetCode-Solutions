class Solution {
    public int longestContinuousSubstring(String s) {
        if (s.length() == 0) return 0;

        int[] values = new int[s.length()];

       
        for (int i = 0; i < s.length(); i++) {
            values[i] = (int) s.charAt(i);
        }

        int max = 1, count = 1;
        
        
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] + 1 == values[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}
