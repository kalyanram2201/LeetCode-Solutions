class Solution {
    public String maximumXor(String s, String t) {
        int zero = 0, one = 0;
        for (char ch : t.toCharArray()) {
            if (ch == '0')
                zero++;
            else
                one++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                if (zero > 0) {
                    sb.append(1);
                    zero--;
                } else
                    sb.append(0);
            } else {
                if (one > 0) {
                    sb.append(1);
                    one--;
                } else
                    sb.append(0);
            }
        }
        return sb.toString();
    }
}