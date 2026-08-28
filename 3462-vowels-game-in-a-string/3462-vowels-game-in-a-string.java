class Solution {
    public boolean doesAliceWin(String s) {

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'a', 'e', 'i', 'o', 'u':
                    return true;
            }
        }

        return false;
    }
}