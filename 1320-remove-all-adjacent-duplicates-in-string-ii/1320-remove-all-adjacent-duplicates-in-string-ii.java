class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (result.length() > 0 && result.charAt(result.length() - 1) == c) {
                int count = stack.peek() + 1;
                stack.pop();
                stack.push(count);
                result.append(c);

                if (count == k) {
                    result.delete(result.length() - k, result.length());
                    stack.pop();
                }
            } else {
                result.append(c);
                stack.push(1);
            }
        }

        return result.toString();
    }
}
