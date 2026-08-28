class Solution {
    public boolean winnerOfGame(String colors) {
        int movesA = 0, movesB = 0;
        int n = colors.length();
        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    movesA++;
                } else {
                    movesB++;
                }
            }
        }
        return movesA > movesB;
    }
}
