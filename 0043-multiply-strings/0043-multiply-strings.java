class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        
        int m=num1.length();
        int n=num2.length();
        int result[]=new int[m+n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int val1=num1.charAt(i)-'0';
                int val2=num2.charAt(j)-'0';
                int product=val1*val2;
                int sum=product+result[i+j+1];

                result[i+j+1]=sum%10;
                result[i+j]+=sum/10;
            }
        }

        StringBuilder str=new StringBuilder();
        boolean leadingZero = true;
        for(int num:result){
            if(num!=0 || !leadingZero){
                str.append(num);
                leadingZero=false;
            }
            
        }
        return str.length()==0?"0":str.toString();
    }
}