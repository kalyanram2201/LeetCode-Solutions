class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = numBottles;
        int count = numBottles;

        while (empty >= numExchange) {
            empty -= numExchange;
            numExchange++;
            count++;
            empty++;
        }

        return count;
    }
}
