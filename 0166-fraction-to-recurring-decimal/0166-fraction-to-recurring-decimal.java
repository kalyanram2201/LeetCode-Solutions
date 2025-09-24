class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder result = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0))
            result.append("-");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);
        long rem = num % den;
        if (rem == 0)
            return result.toString();

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (rem != 0) {
            if (map.containsKey(rem)) {
                int idx = map.get(rem);
                result.insert(idx, "(");
                result.append(")");
                return result.toString();
            }
            map.put(rem, result.length());
            rem *= 10;
            result.append(rem / den);
            rem %= den;
        }

        return result.toString();
    }
}