class Solution {
    public int maxDiff(int num) {
        String str = String.valueOf(num);
        StringBuilder max = new StringBuilder(str);
        StringBuilder min = new StringBuilder(str);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '9') {
                replace(max, str.charAt(i), '9');
                break;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                if (str.charAt(i) != '1') {
                    replace(min, str.charAt(i), '1');
                    break;
                }
            } else {
                if (str.charAt(i) != '0' && str.charAt(i) != min.charAt(0)) {
                    replace(min, str.charAt(i), '0');
                    break;
                }
            }
        }

        int maxVal = Integer.parseInt(max.toString());
        int minVal = Integer.parseInt(min.toString());
        return maxVal - minVal;
    }

    private void replace(StringBuilder sb, char from, char to) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == from) {
                sb.setCharAt(i, to);
            }
        }
    }
}
