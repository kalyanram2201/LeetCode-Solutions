import java.util.*;

class Solution {
    public int countVowelSubstrings(String word) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            Set<Character> temp = new HashSet<>();
            for (int j = i; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (!vowels.contains(ch)) {
                    break;
                }

                temp.add(ch);
                if (temp.size() == 5) {
                    count++;
                }
            }
        }

        return count;
    }
}
