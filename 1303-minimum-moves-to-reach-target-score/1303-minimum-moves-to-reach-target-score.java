class Solution {
    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        while (maxDoubles > 0 && target > 2) {
            if (target % 2 == 0)
                count++;
            else
                count += 2;
            target = target / 2;
            maxDoubles--;

        }
        count = count + target - 1;
        return count;
    }
}