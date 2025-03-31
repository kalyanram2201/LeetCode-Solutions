class Solution {
    public boolean checkZeroOnes(String s) {
        int max0=0,max1=0,count1=0,count0=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                count0++;
                count1=0;
            }else{
                count1++;
                count0=0;
            }
            max1=Math.max(count1,max1);
            max0=Math.max(count0,max0);
        }
        return max1>max0;
    }
}