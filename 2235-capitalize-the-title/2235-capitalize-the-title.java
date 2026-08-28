class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 2) {
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1).toLowerCase());
                result.append(" ");
            }else{
                result.append(word.toLowerCase());
                result.append(" ");
            }
        }

        return result.toString().trim();
    }
}
