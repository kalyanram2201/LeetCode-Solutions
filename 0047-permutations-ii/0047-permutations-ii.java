import java.util.*;

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];

        Arrays.sort(nums);

        permutate(nums, result, used, new ArrayList<>());

        return result;
    }

    void permutate(int[] nums, List<List<Integer>> result, boolean used[], List<Integer> list) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            list.add(nums[i]);

            permutate(nums, result, used, list);

            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}