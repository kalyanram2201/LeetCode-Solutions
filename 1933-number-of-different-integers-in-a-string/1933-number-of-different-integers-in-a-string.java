class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    while (sb.length() > 1 && sb.charAt(0) == '0') {
                        sb.deleteCharAt(0);
                    }
                    set.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        if (sb.length() > 0) {
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
