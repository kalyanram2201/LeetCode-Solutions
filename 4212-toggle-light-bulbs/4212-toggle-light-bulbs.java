class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Set<Integer> set = new HashSet<>();

        for (int num : bulbs) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}