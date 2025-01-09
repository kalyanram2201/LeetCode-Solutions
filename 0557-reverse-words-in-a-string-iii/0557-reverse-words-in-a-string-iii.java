class Solution {
    public String reverseWords(String s) {
        if(s==null || s.trim().isEmpty()){
            return s;
        }

        StringBuilder result=new StringBuilder();
        String words[]=s.split("\\s+");
        for(int i=0;i<words.length;i++){
            result.append(new StringBuilder(words[i]).reverse().toString());
            if(i<words.length){
                result.append(" ");
            }

        }
        return result.toString().trim();
    }
}