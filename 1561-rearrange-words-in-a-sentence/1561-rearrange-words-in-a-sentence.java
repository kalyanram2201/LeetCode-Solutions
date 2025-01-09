class Solution {
    public String arrangeWords(String text) {
        if(text==null || text.length()<1){
            return text;
        }
        String[] s=text.split(" ");
        Arrays.sort(s, (a, b) -> Integer.compare(a.length(), b.length()));
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length;i++){
            if (i == 0) {
                result.append(s[i].substring(0, 1).toUpperCase()).append(s[i].substring(1));
            } else {
                result.append(s[i].toLowerCase());
            }
            if(i<s.length-1){
                result.append(" ");
            }
        }
        return result.toString();
    }
}