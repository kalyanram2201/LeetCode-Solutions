import java.util.*;

class Solution {
    public boolean checkStrings(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        Map<Character, int[]> map1 = new HashMap<>();
        Map<Character, int[]> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            map1.putIfAbsent(c1, new int[2]);
            map2.putIfAbsent(c2, new int[2]);

            map1.get(c1)[i % 2]++;
            map2.get(c2)[i % 2]++;
        }

        for (char ch : map1.keySet()) {
            if (!map2.containsKey(ch))
                return false;

            int[] a = map1.get(ch);
            int[] b = map2.get(ch);

            if (a[0] != b[0] || a[1] != b[1])
                return false;
        }

        return true;
    }
}