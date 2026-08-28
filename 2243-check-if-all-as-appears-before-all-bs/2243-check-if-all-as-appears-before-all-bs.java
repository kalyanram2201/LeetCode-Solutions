class Solution {
    public boolean checkString(String s) {
        boolean b=false;
        for(char c:s.toCharArray()){
            if(c=='b')
                b=true;
            else if(b && c=='a')
                return false;
        }
        return  true;
    }
}