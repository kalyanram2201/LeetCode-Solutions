class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        char ch1 = s1.charAt(0), ch2 = s1.charAt(1), ch3 = s1.charAt(2), ch4 = s1.charAt(3);
        String st1 = "" + ch3 + ch2 + ch1 + ch4;
        String st2 = "" + ch1 + ch4 + ch3 + ch2;
        String st3 = "" + ch3 + ch4 + ch1 + ch2;
        return st1.equals(s2) || st2.equals(s2) || st3.equals(s2) ? true : false;
    }
}