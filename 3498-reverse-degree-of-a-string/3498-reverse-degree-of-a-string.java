class Solution {
    public int reverseDegree(String s) {
        int sum = 0, i = 1;
        for (char ch : s.toCharArray()) {
            sum += ((26 - (ch - 'a')) * i++);
        }
        return sum;
    }
}