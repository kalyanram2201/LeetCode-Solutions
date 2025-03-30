import java.util.*;

class Solution {
    public String sortSentence(String s) {
        String[] result = new String[9]; 
        String[] words = s.split(" ");

        
        for (String word : words) {
            int n = word.charAt(word.length() - 1) - '0'; 
            result[n - 1] = word.substring(0, word.length() - 1);
        }

        StringBuilder sc = new StringBuilder();
        for (String word : result) {
            if (word != null) { 
                sc.append(word).append(" ");
            }
        }

        return sc.toString().trim(); 
    }

}
