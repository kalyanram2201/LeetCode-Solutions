class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0){
            return 0;
        }

        boolean isNeg=false;
        int i=0;
        if(s.charAt(0)=='-'||s.charAt(0)=='+'){
            if(s.charAt(i)=='-')isNeg=true;
            i++;
        }
        
        long num=0;

        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i)-'0';
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num=num*10+digit;
            i++;

        }
         
        
        return  isNeg?(int)-num:(int)num;
       
    }
}