class Solution {
    long[][]c=new long[55][55];
    public long nthSmallest(long n, int k) {
        combinations();
        long result=0;
        int rem=k;
        for(int i=50;i>=0;i--){
            if(rem==0)break;
            long count=0;
            if(i>=rem){
                count=c[i][rem];
            }
            if(count>=n){
                continue;
            }else{
                n-=count;
                result|=(1L<<i);
                rem--;
            }
        }
        return result;
    }
    void combinations(){
        for(int i=0;i<=50;i++){
            c[i][0]=c[i][i]=1;
            for(int j=1;j<i;j++){
                c[i][j]=c[i-1][j-1]+c[i-1][j];
            }
        }
    }
}