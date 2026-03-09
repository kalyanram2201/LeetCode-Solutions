import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        permutate(result, list, 0);

        return result;
    }

    void permutate(List<List<Integer>> result, List<Integer> list, int ind) {

        if (ind == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = ind; i < list.size(); i++) {

            Collections.swap(list, ind, i);

            permutate(result, list, ind + 1);

            Collections.swap(list, ind, i);
        }
    }
}