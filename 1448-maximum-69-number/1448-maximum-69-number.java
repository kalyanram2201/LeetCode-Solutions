class Solution {
    public int maximum69Number(int num) {
        String val = Integer.toString(num);
        val = val.replaceFirst("6", "9");
        return Integer.parseInt(val);
    }
}
