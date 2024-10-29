class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return x;
        return (int)Math.floor((int)Math.pow(x,0.5));
    }
}