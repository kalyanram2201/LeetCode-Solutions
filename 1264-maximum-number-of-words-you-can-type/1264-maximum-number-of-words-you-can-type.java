class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        int count = 0;
        for (String word : arr) {
            boolean contains = false;
            for (char ch : brokenLetters.toCharArray()) {
                if (word.indexOf(ch) >= 0) {
                    contains = true;
                }
            }
            if (!contains) {
                count++;
            }
        }
        
        return count;
    }
}