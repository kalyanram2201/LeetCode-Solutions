import java.util.regex.Pattern;

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        String sep = Pattern.quote(String.valueOf(separator));
        
        for (String word : words) {
            String[] str = word.split(sep);
            for (String temp : str) {
                if (!temp.isEmpty()) {
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
