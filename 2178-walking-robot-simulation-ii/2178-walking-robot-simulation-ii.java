class Robot {
    int w, h;
    int x, y;
    int dir, per;

    public Robot(int width, int height) {
        w = width;
        h = height;
        x = y = dir = 0;
        per = 2 * (w + h) - 4;
    }

    public void step(int num) {
        if (per == 0)
            return;
        num %= per;
        if (num == 0) {
            if (x == 0 && y == 0) {
                dir = 3;
            }
            return;
        }

        while (num > 0) {
            if (dir == 0) {
                int mov = Math.min(num, w - 1 - x);
                x += mov;
                num -= mov;
                if (num > 0)
                    dir = 1;
            } else if (dir == 1) {
                int mov = Math.min(num, h - 1 - y);
                y += mov;
                num -= mov;
                if (num > 0)
                    dir = 2;
            } else if (dir == 2) {
                int mov = Math.min(num, x);
                x -= mov;
                num -= mov;
                if (num > 0)
                    dir = 3;
            } else {
                int mov = Math.min(num, y);
                y -= mov;
                num -= mov;
                if (num > 0)
                    dir = 0;
            }
        }
    }

    public int[] getPos() {
        return new int[] { x, y };
    }

    public String getDir() {
        if (dir == 0)
            return "East";
        if (dir == 1)
            return "North";
        if (dir == 2)
            return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */