class Solution {
     public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                str.append(Character.toLowerCase(ch));
            }
        }

        String nonrev = str.toString();
        String rev = str.reverse().toString();
        return nonrev.equals(rev);
    }
}