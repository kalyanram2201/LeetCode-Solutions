class Solution {
    public boolean canAliceWin(int[] nums) {
        int Ssum = 0, Dsum = 0;
        for (int num : nums) {
            if (num >= 1 && num <= 9) {
                Ssum += num;
            } else {
                Dsum += num;
            }
        }
        if (Ssum != Dsum)
            return true;
        return false;
    }
}