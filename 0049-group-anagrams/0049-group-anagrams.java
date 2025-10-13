class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> result = new ArrayList<>();
        List<Map<Character, Integer>> freqList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        for (String word : strs) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : word.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            freqList.add(map);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < n; j++) {
                if (!visited[j] && freqList.get(i).equals(freqList.get(j))) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(group);
        }

        return result;
    }
}
