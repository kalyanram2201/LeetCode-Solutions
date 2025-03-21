import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        
        for (int num : nums) {
            list.add(String.valueOf(num));
        }

        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));

        if (list.get(0).equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        for (String num : list) {
            result.append(num);
        }

        return result.toString();
    }
}
