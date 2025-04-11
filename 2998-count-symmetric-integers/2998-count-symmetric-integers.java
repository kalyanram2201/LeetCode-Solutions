class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            String num = String.valueOf(i);
            int len = num.length();
            
            if (len % 2 != 0) continue;  

            int sumf = 0, sumb = 0;

            for (int j = 0; j < len / 2; j++) {
                sumf += num.charAt(j) - '0';                     
                sumb += num.charAt(len - 1 - j) - '0';           
            }

            if (sumf == sumb) {
                count++;
            }
        }

        return count;
    }
}
