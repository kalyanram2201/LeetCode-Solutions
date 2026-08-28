class Solution {
    public String convertDateToBinary(String date) {
        StringBuilder result = new StringBuilder();
        int year = Integer.parseInt(date.substring(0, 4));
        result.append(Integer.toBinaryString(year));
        result.append('-');

        int m = Integer.parseInt(date.substring(5, 7));
        result.append(Integer.toBinaryString(m));
        result.append('-');

        int d = Integer.parseInt(date.substring(8, 10));
        result.append(Integer.toBinaryString(d));

        return result.toString();
    }
}