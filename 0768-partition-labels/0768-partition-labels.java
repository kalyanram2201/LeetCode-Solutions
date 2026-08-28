import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int left = 0, n = s.length();
        List<Integer> result = new ArrayList<>();

        while (left < n) {
            int right = left; 
            int last = s.lastIndexOf(s.charAt(left)); 
            
            while (right <= last) {
                last = Math.max(last, s.lastIndexOf(s.charAt(right)));
                right++;
            }
            
            result.add(right - left); 
            left = right; 
        }
        
        return result;
    }
}
