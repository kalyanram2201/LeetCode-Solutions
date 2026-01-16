class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = Arrays.copyOf(hFences, hFences.length + 2);
        int[] v = Arrays.copyOf(vFences, vFences.length + 2);

        h[hFences.length] = 1;
        h[hFences.length + 1] = m;

        v[vFences.length] = 1;
        v[vFences.length + 1] = n;

        Arrays.sort(h);
        Arrays.sort(v);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                set.add(h[j] - h[i]);
            }
        }

        long max = -1;
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int diff = v[j] - v[i];
                if (set.contains(diff)) {
                    max = Math.max(max, diff);
                }
            }
        }

        return max == -1 ? -1 : (int) ((max * max) % 1_000_000_007);
    }
}
