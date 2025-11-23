class Solution {
    public int maxBalancedSubarray(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0*0", -1);
        int xor = 0, max = 0, bal = 0;
        
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            bal += nums[i] % 2 == 0 ? 1 : -1;
            String key = xor + "*" + bal;
            
            if (map.containsKey(key)) {
                int len = i - map.get(key);
                if (len >= 2)
                    max = Math.max(max, len);
            } else {
                map.put(key, i);
            }
        }
        
        return max;
    }
}