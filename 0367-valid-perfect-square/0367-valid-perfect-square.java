class Solution {
    public boolean isPerfectSquare(int num) {
        int val = (int) Math.sqrt(num);
        return val * val == num;
    }
}