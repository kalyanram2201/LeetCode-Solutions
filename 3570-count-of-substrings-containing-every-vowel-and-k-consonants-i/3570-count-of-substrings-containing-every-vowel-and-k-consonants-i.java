class Solution {
    public int countOfSubstrings(String word, int k) {
        if (word.length() < 5)
            return 0;

        int result = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < word.length(); i++) {
            Set<Character> vowels = new HashSet<>();
            int con = 0;

            for (int j = i; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (set.contains(ch)) {
                    vowels.add(ch);
                } else {
                    con++;
                }

                if (con > k)
                    break;

                if (vowels.size() == 5 && con == k) {
                    result++;
                }
            }
        }

        return result;
    }
}
