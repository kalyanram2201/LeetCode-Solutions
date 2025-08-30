import java.util.*;

class Solution {
    public int getLeastFrequentDigit(int n) {
        String val = Integer.toString(n);
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : val.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int result = -1;
        int min = Integer.MAX_VALUE;

        for (char ch : map.keySet()) {
            int freq = map.get(ch);
            int digit = ch - '0';

            if (freq < min || (freq == min && digit < result)) {
                min = freq;
                result = digit;
            }
        }
        return result;
    }
}
