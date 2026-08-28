class Solution {
    public int minSensors(int n, int m, int k) {
        int block = 2 * k + 1;
        int rows = (n + block - 1) / block;
        int cols = (m + block - 1) / block;

        return rows * cols;
    }
}