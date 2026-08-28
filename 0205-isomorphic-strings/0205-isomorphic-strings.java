class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mpp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (mpp.containsKey(chS)) {
                if (mpp.get(chS) != chT) return false;
            } else {
                if (mpp.containsValue(chT)) return false;
                mpp.put(chS, chT);
            }
        }
        return true;
    }
}
