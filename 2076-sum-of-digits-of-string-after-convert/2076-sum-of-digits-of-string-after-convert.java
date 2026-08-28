class Solution {
    public int getLucky(String s, int k) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            int val = c - 'a' + 1;
            str.append(val);
        }

        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (int j = 0; j < str.length(); j++) {
                sum += str.charAt(j) - '0';
            }
            str.setLength(0);
            str.append(sum);
        }

        return Integer.parseInt(str.toString());
    }
}
