class Solution {
    String[] twenty = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        return convert(num).trim();
    }

    private String convert(int num) {
        if (num < 20) {
            return twenty[num];
        } else if (num < 100) {
            return tens[num / 10] + (num % 10 != 0 ? " " + convert(num % 10) : "");
        } else if (num < 1000) {
            return convert(num / 100) + " Hundred" + (num % 100 != 0 ? " " + convert(num % 100) : "");
        } else if (num < 1_000_000) {
            return convert(num / 1000) + " Thousand" + (num % 1000 != 0 ? " " + convert(num % 1000) : "");
        } else if (num < 1_000_000_000) {
            return convert(num / 1_000_000) + " Million" + (num % 1_000_000 != 0 ? " " + convert(num % 1_000_000) : "");
        } else {
            return convert(num / 1_000_000_000) + " Billion"
                    + (num % 1_000_000_000 != 0 ? " " + convert(num % 1_000_000_000) : "");
        }
    }
}
