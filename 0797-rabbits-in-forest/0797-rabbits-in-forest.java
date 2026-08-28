class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        int sum = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);
            int groupSize = key + 1;
            int groups = (count + groupSize - 1) / groupSize; 
            sum += groups * groupSize;
        }

        return sum;
    }
}
