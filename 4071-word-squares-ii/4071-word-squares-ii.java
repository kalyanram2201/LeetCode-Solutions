class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        int n = words.length;
        Arrays.sort(words);
        for (int i = 0; i < n; i++) {
            String top = words[i];
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                String left = words[j];
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k)
                        continue;
                    String right = words[k];
                    for (int p = 0; p < n; p++) {
                        if (i == p || j == p || k == p)
                            continue;
                        String bottom = words[p];
                        if (bottom.charAt(0) == left.charAt(3) &&
                                bottom.charAt(3) == right.charAt(3) &&
                                        top.charAt(0) == left.charAt(0) &&
                                        top.charAt(3) == right.charAt(0)) {
                            result.add(Arrays.asList(top, left, right, bottom));
                        }
                    }
                }
            }
        }
        return result;
    }
}