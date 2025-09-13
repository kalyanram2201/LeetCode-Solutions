import java.util.*;

class Solution {
    public int maxFreqSum(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> v = new HashMap<>();
        Map<Character, Integer> c = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                v.put(ch, v.getOrDefault(ch, 0) + 1);
            } else {
                c.put(ch, c.getOrDefault(ch, 0) + 1);
            }
        }

        int maxv = 0, maxc = 0;
        for (int val : v.values()) {
            maxv = Math.max(maxv, val);
        }
        for (int val : c.values()) {
            maxc = Math.max(maxc, val);
        }

        return maxv + maxc;
    }
}
