class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int bin = 0;

        for (int bit : nums) {
            bin = (bin * 2 + bit) % 5;
            result.add(bin == 0);
        }

        return result;
    }
}
