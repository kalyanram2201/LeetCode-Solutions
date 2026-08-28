import java.util.HashMap;

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        HashMap<Integer, Boolean> map = new HashMap<>();
        int unplacedCount = 0;

        
        for (int i = 0; i < n; i++) {
            boolean isPlaced = false;

           
            for (int j = 0; j < n; j++) {
                
                if (!map.getOrDefault(j, false) && fruits[i] <= baskets[j]) {
                    map.put(j, true); 
                    isPlaced = true;
                    break;
                }
            }

           
            if (!isPlaced) {
                unplacedCount++;
            }
        }

        return unplacedCount;
    }
}