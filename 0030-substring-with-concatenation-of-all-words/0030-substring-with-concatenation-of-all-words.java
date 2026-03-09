class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        int m = words[0].length();

        Map<String, Integer> word = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (String str : words) {
            word.put(str, word.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> map = new HashMap<>();

            for (int j = i; j + m <= s.length(); j += m) {

                String w = s.substring(j, j + m);

                if (word.containsKey(w)) {

                    map.put(w, map.getOrDefault(w, 0) + 1);
                    count++;

                    while (map.get(w) > word.get(w)) {
                        String lw = s.substring(left, left + m);
                        map.put(lw, map.get(lw) - 1);
                        left += m;
                        count--;
                    }

                    if (count == n) {
                        result.add(left);
                    }

                } else {
                    map.clear();
                    count = 0;
                    left = j + m;
                }
            }
        }

        return result;
    }
}