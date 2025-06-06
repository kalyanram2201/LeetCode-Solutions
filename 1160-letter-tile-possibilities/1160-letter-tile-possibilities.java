class Solution {
    Set<String> set = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        backtrack(tiles, "", used);
        return set.size();
    }

    void backtrack(String tiles, String path, boolean[] used) {
        for (int i = 0; i < tiles.length(); i++) {
            if (used[i])
                continue;

            used[i] = true;
            String newPath = path + tiles.charAt(i);
            set.add(newPath);
            
            backtrack(tiles, newPath, used);
            used[i] = false;
        }
    }
}
