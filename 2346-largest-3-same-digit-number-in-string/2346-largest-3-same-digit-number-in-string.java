class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String max = "";

        for (int i = 0; i <= n - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                String sub = num.substring(i, i + 3);
                if (max.equals("") || sub.compareTo(max) > 0) {
                    max = sub;
                }
            }
        }

        return max;
    }
}
