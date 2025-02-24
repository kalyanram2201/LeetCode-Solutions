class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        if(n==0){
            return 0;
        }
        int x=0,y=0;

        for (String command : commands) {
            switch (command) {
                case "UP":
                    y = Math.max(y - 1, 0); 
                    break;
                case "DOWN":
                    y = Math.min(y + 1, n - 1);
                    break;
                case "LEFT":
                    x = Math.max(x - 1, 0);
                    break;
                case "RIGHT":
                    x = Math.min(x + 1, n - 1);
                    break;
            }
        }
        int val=(y*n)+x;
        return val;
    }
}