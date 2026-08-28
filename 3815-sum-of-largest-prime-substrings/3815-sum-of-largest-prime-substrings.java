import java.math.BigInteger;
import java.util.*;

class Solution {
    public long sumOfLargestPrimes(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<BigInteger> primes = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                String sub = sb.toString();

                if (sub.length() > 1 && sub.charAt(0) == '0') continue;

                BigInteger num = new BigInteger(sub);
                if (num.compareTo(BigInteger.ONE) > 0 && num.isProbablePrime(10)) {
                    primes.add(num);
                }
            }
        }

        List<BigInteger> sorted = new ArrayList<>(primes);
        sorted.sort(Collections.reverseOrder());

        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < Math.min(3, sorted.size()); i++) {
            sum = sum.add(sorted.get(i));
        }

        return sum.longValue();
    }
    
}
