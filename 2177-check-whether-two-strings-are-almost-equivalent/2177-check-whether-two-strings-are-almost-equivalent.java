class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        for (char c : map1.keySet()) {
            if (Math.abs(map1.get(c) - map2.getOrDefault(c, 0)) > 3) {
                return false;
            }
        }
        for (char c : map2.keySet()) {
            if (!map1.containsKey(c) && map2.get(c) > 3) {
                return false;
            }
        }
        return true;

    }
}