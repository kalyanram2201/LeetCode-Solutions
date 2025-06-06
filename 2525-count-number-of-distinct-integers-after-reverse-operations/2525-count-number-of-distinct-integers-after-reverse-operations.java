class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> result = new HashSet<>();
        
        for (int num : nums) {
            result.add(num);
        }

        for (int num : nums) {
            int reversed = Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
            result.add(reversed);
        }

        return result.size();
    }
}
