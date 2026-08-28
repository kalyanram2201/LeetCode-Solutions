import java.util.*;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int neg = 0;
        long result = 0;
        int i = happiness.length - 1;

        while (k > 0 && i >= 0) {
            int val = happiness[i] - neg;
            if (val <= 0)
                break;

            result += val;
            neg++;
            k--;
            i--;
        }
        return result;
    }
}
