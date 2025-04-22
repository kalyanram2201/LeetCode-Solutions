class Solution {
    public String firstPalindrome(String[] words) {
        if (words.length == 0)
            return "";

        for (String word : words) {
            if (palindrome(word)) {
                return word;
            }
        }

        return "";
    }

    boolean palindrome(String word) {
        int left = 0, right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}