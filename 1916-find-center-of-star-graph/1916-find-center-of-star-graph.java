class Solution {
    public int findCenter(int[][] edges) {
        
        int val1 = edges[0][0], val2 = edges[0][1];
        int val3 = edges[1][0], val4 = edges[1][1];

        if (val1 == val3 || val1 == val4) {
            return val1;
        } 
        return val2;

    }
}