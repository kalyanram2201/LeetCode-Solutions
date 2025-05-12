class Solution {
    public int[] findEvenNumbers(int[] digits) {
        boolean[] seen = new boolean[1000]; 
        List<Integer> result = new ArrayList<>();

        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; 
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int val = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (val % 2 == 0 && !seen[val]) {
                        seen[val] = true;
                        result.add(val);
                    }
                }
            }
        }

        Collections.sort(result); 

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
