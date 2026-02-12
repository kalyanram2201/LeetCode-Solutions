class Solution {

    private boolean isValid(int[] frequencyArray) {
        int targetCount = 0;

        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] == 0)
                continue;

            if (targetCount == 0)
                targetCount = frequencyArray[i];
            else if (frequencyArray[i] != targetCount)
                return false;
        }

        return true;
    }

    public int longestBalanced(String inputString) {
        int maxLength = Integer.MIN_VALUE;

        for (int startIndex = 0; startIndex < inputString.length(); startIndex++) {
            int[] frequencyArray = new int[26];

            for (int endIndex = startIndex; endIndex < inputString.length(); endIndex++) {
                frequencyArray[inputString.charAt(endIndex) - 'a']++;

                if (isValid(frequencyArray))
                    maxLength = Math.max(maxLength, endIndex - startIndex + 1);
            }
        }

        return maxLength;
    }
}
