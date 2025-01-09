class Solution {
    public String reverseWords(String s) {
        if(s==null || s.trim().isEmpty()){
            return s;
        }
        StringBuilder result=new StringBuilder();
        String words[]=s.split("\\s+");
        for(int i=words.length-1;i>=0;i--){
            result.append(words[i]);
            if(i>0){
                result.append(" ");
            }
        }
        return result.toString().trim();
    }
}