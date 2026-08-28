class Solution {
    public String largestEven(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '2') {
                break;
            }

            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}