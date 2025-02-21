class Solution {
    public int reverse(int x) {
        if(x<10 && x>-10){
            return x;
        }
        int temp=x;
        int sum=0;
        while(temp!=0){
            int digit=temp%10;
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            sum=sum*10+digit;
            temp=temp/10;
        }
        return sum;
    }
}