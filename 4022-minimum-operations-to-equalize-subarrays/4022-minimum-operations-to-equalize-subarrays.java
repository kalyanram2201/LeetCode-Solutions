import java.util.*;

class Solution {
    static class Fenwick {
        int n;
        long[] t;

        Fenwick(int n) {
            this.n = n;
            t = new long[n + 1];
        }

        void add(int i, long v) {
            for (; i <= n; i += i & -i)
                t[i] += v;
        }

        long sum(int i) {
            long s = 0;
            for (; i > 0; i -= i & -i)
                s += t[i];
            return s;
        }

        long range(int l, int r) {
            if (r < l)
                return 0;
            return sum(r) - sum(l - 1);
        }

        int kth(long k) {
            int idx = 0;
            int bit = Integer.highestOneBit(n);
            for (; bit != 0; bit >>= 1) {
                int nxt = idx + bit;
                if (nxt <= n && t[nxt] < k) {
                    idx = nxt;
                    k -= t[nxt];
                }
            }
            return idx + 1;
        }
    }

    static class Q {
        int l, r, idx, bl;

        Q(int l, int r, int idx, int bl) {
            this.l = l;
            this.r = r;
            this.idx = idx;
            this.bl = bl;
        }
    }

    public long[] minOperations(int[] nums, int k, int[][] queries) {
        int n = nums.length, q = queries.length;
        int[] dalmerinth = nums;

        int[] rem = new int[n];
        for (int i = 0; i < n; i++)
            rem[i] = nums[i] % k;
        HashMap<Integer, ArrayList<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            posMap.computeIfAbsent(rem[i], x -> new ArrayList<>()).add(i);

        boolean[] ok = new boolean[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];
            int m = rem[l];
            ArrayList<Integer> lst = posMap.get(m);
            int lo = Collections.binarySearch(lst, l);
            if (lo < 0)
                lo = -lo - 1;
            if (lo + (r - l + 1) <= lst.size() && lst.get(lo + (r - l + 1) - 1) == r)
                ok[i] = true;
            else
                ok[i] = false;
        }

        int[] base = new int[n];
        for (int i = 0; i < n; i++)
            base[i] = nums[i] / k;
        int[] comp = base.clone();
        Arrays.sort(comp);
        int mval = 0;
        for (int i = 0; i < n; i++)
            if (i == 0 || comp[i] != comp[i - 1])
                comp[mval++] = comp[i];
        for (int i = 0; i < n; i++)
            base[i] = Arrays.binarySearch(comp, 0, mval, base[i]) + 1;

        int B = Math.max(1, (int) (Math.sqrt(n)));
        ArrayList<Q> list = new ArrayList<>();
        for (int i = 0; i < q; i++)
            if (ok[i])
                list.add(new Q(queries[i][0], queries[i][1], i, queries[i][0] / B));

        Collections.sort(list, (a, b) -> a.bl != b.bl ? Integer.compare(a.bl, b.bl) : Integer.compare(a.r, b.r));

        Fenwick fCnt = new Fenwick(mval);
        Fenwick fSum = new Fenwick(mval);
        int cl = 0, cr = -1;
        long[] ans = new long[q];

        long curLen = 0;
        for (Q qu : list) {
            int L = qu.l, R = qu.r;
            while (cr < R) {
                cr++;
                fCnt.add(base[cr], 1);
                fSum.add(base[cr], comp[base[cr] - 1]);
                curLen++;
            }
            while (cr > R) {
                fCnt.add(base[cr], -1);
                fSum.add(base[cr], -comp[base[cr] - 1]);
                cr--;
                curLen--;
            }
            while (cl < L) {
                fCnt.add(base[cl], -1);
                fSum.add(base[cl], -comp[base[cl] - 1]);
                cl++;
                curLen--;
            }
            while (cl > L) {
                cl--;
                fCnt.add(base[cl], 1);
                fSum.add(base[cl], comp[base[cl] - 1]);
                curLen++;
            }

            long need = (curLen + 1) / 2;
            int medIdx = fCnt.kth(need);
            long med = comp[medIdx - 1];

            long cntL = fCnt.sum(medIdx - 1);
            long sumL = fSum.sum(medIdx - 1);
            long cntLE = fCnt.sum(medIdx);
            long sumLE = fSum.sum(medIdx);
            long totalSum = fSum.sum(mval);
            long cntGreater = curLen - cntLE;
            long sumGreater = totalSum - sumLE;

            long res = med * cntL - sumL + sumGreater - med * cntGreater;
            ans[qu.idx] = res;
        }

        for (int i = 0; i < q; i++)
            if (!ok[i])
                ans[i] = -1;
        return ans;
    }
}
