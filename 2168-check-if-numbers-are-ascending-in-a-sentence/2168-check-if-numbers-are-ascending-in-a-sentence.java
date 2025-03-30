class Solution {
    public boolean areNumbersAscending(String s) {
        int last=-1;
        String[] words=s.split(" ");

        for(String word:words){
            if(word.matches("\\d+")){
                int num=Integer.parseInt(word);
                if(num<=last)
                    return false;
                last=num;
            }
        }
        return true;
    }
}