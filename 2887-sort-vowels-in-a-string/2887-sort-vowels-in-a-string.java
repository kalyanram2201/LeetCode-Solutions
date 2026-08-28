class Solution {
    public String sortVowels(String s) {
        String vovel = "AEIOUaeiou";
        List<Character> list = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (vovel.indexOf(ch) >= 0) {
                list.add(ch);
            }
        }
        Collections.sort(list);
        StringBuilder result = new StringBuilder();
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (vovel.indexOf(ch) >= 0) {
                result.append(list.get(i++));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}