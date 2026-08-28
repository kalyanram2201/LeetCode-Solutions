class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> rn = new HashMap<>();
        HashMap<Character, Integer> mz = new HashMap<>();

        for (char ch : ransomNote.toCharArray()) {
            rn.put(ch, rn.getOrDefault(ch, 0) + 1);
        }

        for (char ch : magazine.toCharArray()) {
            mz.put(ch, mz.getOrDefault(ch, 0) + 1);
        }

        for (char ch : rn.keySet()) {
            if (!mz.containsKey(ch) || rn.get(ch) > mz.get(ch)) {
                return false;
            }
        }

        return true;
    }
}
