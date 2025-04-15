class Solution {

    public long goodTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        long[] segmentTree = new long[n * 4 + 1];
        long ans = 0;
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        helper(segmentTree, 1, 0, n - 1, map.get(nums1[0]));
        for (int i = 1; i < n; i++) {
            int idx = map.get(nums1[i]);
            long commonL = query(segmentTree, 1, 0, n - 1, 0, idx);
            long eleA = i - commonL;
            long eleidx = n - 1 - idx;
            long commonR = eleidx - eleA;
            ans += commonL * commonR;
            helper(segmentTree, 1, 0, n - 1, idx);
        }
        return ans;
    }

    private void helper(long[] st, int index, int start, int end, int helperIndex) {
        if (start == end) {
            st[index] += 1;
            return;
        }
        int mid = start + (end - start) / 2;
        if (helperIndex <= mid)
            helper(st, index * 2, start, mid, helperIndex);
        else
            helper(st, index * 2 + 1, mid + 1, end, helperIndex);
        st[index] = st[index * 2] + st[index * 2 + 1];
    }

    private long query(long[] st, int index, int start, int end, int queryStart, int queryEnd) {
        if (end < queryStart || start > queryEnd)
            return 0;
        if (start >= queryStart && end <= queryEnd)
            return st[index];
        int mid = start + (end - start) / 2;
        long left = query(st, index * 2, start, mid, queryStart, queryEnd);
        long right = query(st, index * 2 + 1, mid + 1, end, queryStart, queryEnd);
        return left + right;
    }
}