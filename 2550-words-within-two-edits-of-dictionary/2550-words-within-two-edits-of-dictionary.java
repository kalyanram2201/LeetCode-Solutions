class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        List<String> res = new ArrayList<>();
        for (String word : queries) {
            for (String temp : dictionary) {
                int count = 0;
                for (int i = 0; i < temp.length(); i++) {
                    if (word.charAt(i) != temp.charAt(i))
                        count++;
                    if (count > 2)
                        break;
                }
                if (count <= 2) {
                    res.add(word);
                    break;
                }
            }
        }
        return res;
    }
}