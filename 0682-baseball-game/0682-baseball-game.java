class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (String ch : operations) {
            if (!ch.equals("C") && !ch.equals("D") && !ch.equals("+")) {
                int num = Integer.parseInt(ch);
                stack.push(num);
                list.add(num);
            } else if (ch.equals("C")) {
                stack.pop();
                list.remove(list.size() - 1);
            } else if (ch.equals("D")) {
                int val = stack.peek();
                stack.push(val * 2);
                list.add(val * 2);
            } else {
                int val1 = list.get(list.size() - 1);
                int val2 = list.get(list.size() - 2);
                stack.push(val1 + val2);
                list.add(val1 + val2);
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
