class Solution {
    public char kthCharacter(int k) {
        if (k < 0)
            return '\0';

        StringBuilder sb = new StringBuilder("a");

        while (sb.length() <= k) {
            StringBuilder temp = new StringBuilder();
            for (char ch : sb.toString().toCharArray()) {
                if (ch == 'z')
                    temp.append('a');
                else
                    temp.append((char) (ch + 1));
            }
            sb.append(temp);
        }

        return sb.charAt(k - 1);
    }
}
