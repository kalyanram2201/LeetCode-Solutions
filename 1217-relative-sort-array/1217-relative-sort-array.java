class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr2)
            list.add(num);

        List<Integer> temp = new ArrayList<>();
        for (int num : arr1)
            temp.add(num);

        List<Integer> result = new ArrayList<>();
        List<Integer> last = new ArrayList<>();

        for (int num : list) {
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) == num) {
                    result.add(temp.get(i));
                }
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            if (!list.contains(temp.get(i))) {
                last.add(temp.get(i));
            }
        }

        Collections.sort(last);
        result.addAll(last);

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}