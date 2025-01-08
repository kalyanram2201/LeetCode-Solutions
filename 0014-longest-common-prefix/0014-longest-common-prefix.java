class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer st=new StringBuffer();
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];
        int i=0;
        while(true){
            if(i<s1.length() && i<s2.length() && s1.charAt(i)==s2.charAt(i)){
                st.append(s1.charAt(i));
            }else{
                break;
            }
            i++;
        }
        return st.toString();
    }
}