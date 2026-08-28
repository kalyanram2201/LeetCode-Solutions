class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        if (words.length == 0)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;

    }
}