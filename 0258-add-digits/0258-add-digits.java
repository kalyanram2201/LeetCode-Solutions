class Solution {
    public int addDigits(int num) {
        if(num<10){
            return num;
        }
        int temp=num;
        while(temp>=10){
            int x=temp;
            int sum=0;
            while(x!=0){
                sum+=x%10;
                x=x/10;
            }
            temp=sum;
        }
        return temp;
        
    }
}