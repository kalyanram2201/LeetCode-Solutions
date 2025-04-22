import java.util.*;

class Solution {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        char maxChar = 0;
        for (char c : set) {
            if (Character.isLetter(c) &&
                set.contains(Character.toUpperCase(c)) &&
                set.contains(Character.toLowerCase(c))) {
                char upper = Character.toUpperCase(c);
                if (upper > maxChar) {
                    maxChar = upper;
                }
            }
        }

        return maxChar == 0 ? "" : Character.toString(maxChar);
    }
}
