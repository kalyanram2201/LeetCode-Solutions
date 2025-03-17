import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // Handle multi-digit numbers
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currStr);
                num = 0;
                currStr = new StringBuilder();
            } else if (c == ']') {
                int repeatTimes = numStack.pop();
                StringBuilder decoded = strStack.pop();
                decoded.append(String.valueOf(currStr).repeat(repeatTimes));
                currStr = decoded;
            } else {
                currStr.append(c);
            }
        }
        return currStr.toString();
    }
}
