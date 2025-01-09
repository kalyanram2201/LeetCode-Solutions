class Solution {
    public void reverseString(char[] s) {
        if(s==null ||s.length<2){
            return;
        }

        int first=0;
        int last=s.length-1;
        while(first<last){
            char temp=s[last];
            s[last]=s[first];
            s[first]=temp;
            first++;
            last--;
        }
    }
}