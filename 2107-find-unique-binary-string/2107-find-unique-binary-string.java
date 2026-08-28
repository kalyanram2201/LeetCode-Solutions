class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        int n = nums[0].length();
        for(String s : nums) set.add(s);

        int limit = 1 << n;

        for(int i = 0; i < limit; i++){
            String s = Integer.toBinaryString(i);
            while(s.length() < n) s = "0" + s;
            if(!set.contains(s)) return s;
        }
        return "";
    }
}