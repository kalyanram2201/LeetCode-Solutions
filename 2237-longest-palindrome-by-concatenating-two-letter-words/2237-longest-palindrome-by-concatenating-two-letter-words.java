class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            String rev = reverse(word);
            if (map.getOrDefault(rev, 0) > 0) {
                count += 4;
                map.put(rev, map.get(rev) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                hasMiddle = true;
                break;
            }
        }

        return hasMiddle ? count + 2 : count;
    }

    String reverse(String word) {
        return "" + word.charAt(1) + word.charAt(0);
    }
}
