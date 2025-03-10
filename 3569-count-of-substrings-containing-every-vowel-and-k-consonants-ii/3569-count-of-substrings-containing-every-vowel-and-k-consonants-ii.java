import java.util.*;

class Solution {
    public long countOfSubstrings(String word, int k) {
        return countAtLeastK(word, k) - countAtLeastK(word, k + 1);
    }

    private long countAtLeastK(String word, int k) {
        int n = word.length();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        long count = 0;
        int left = 0, consonantCount = 0;
        Map<Character, Integer> vowelFreq = new HashMap<>();
        
        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);

            if (vowels.contains(c)) {
                vowelFreq.put(c, vowelFreq.getOrDefault(c, 0) + 1);
            } else {
                consonantCount++;
            }

            while (vowelFreq.size() == 5 && consonantCount >= k) {
                count += (n - right); 

                char leftChar = word.charAt(left);
                if (vowels.contains(leftChar)) {
                    if (vowelFreq.get(leftChar) == 1) {
                        vowelFreq.remove(leftChar);
                    } else {
                        vowelFreq.put(leftChar, vowelFreq.get(leftChar) - 1);
                    }
                } else {
                    consonantCount--;
                }
                left++;
            }
        }
        
        return count;
    }
}
