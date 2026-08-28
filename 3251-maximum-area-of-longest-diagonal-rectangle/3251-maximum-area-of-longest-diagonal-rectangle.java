class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int result = 0;
        double max = 0;
        for (int temp[] : dimensions) {
            int d1 = temp[0], d2 = temp[1];
            double val = Math.sqrt(d1 * d1 + d2 * d2);
            if (max < val) {
                result = d1 * d2;
                max=val;
            }else if(max==val && result<(d1*d2)){
                result=d1*d2;
            }
        }
        return result;
    }
}