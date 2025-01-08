class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder st=new StringBuilder();
        while(columnNumber>0){
            int rem=columnNumber%26;
            if(rem==0){
                st.append('Z');
                columnNumber=(columnNumber/26)-1;
            }else{
                st.append((char)((rem - 1) + 'A'));
                columnNumber=columnNumber/26;
            }
        }
        return st.reverse().toString();

    }
}