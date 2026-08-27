class Solution {
    static final int MOD = 1_000_000_007;

    public int minAdjacentSwaps(int[] nums, int a, int b) {
        int n = nums.length;
        List<Integer> less = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int x : nums) {
            if (x < a)
                less.add(x);
            else if (x > b)
                greater.add(x);
            else
                mid.add(x);
        }

        List<Integer> target = new ArrayList<>();
        target.addAll(less);
        target.addAll(mid);
        target.addAll(greater);

        Map<Integer, Queue<Integer>> posMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            posMap.computeIfAbsent(target.get(i), k -> new LinkedList<>()).offer(i);
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = posMap.get(nums[i]).poll();
        }

        Fenwick bit = new Fenwick(n);
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            ans += bit.query(arr[i]);
            ans %= MOD;
            bit.update(arr[i] + 1, 1);
        }

        return (int) (ans % MOD);
    }

    class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n + 2;
            tree = new int[this.n];
        }

        void update(int idx, int val) {
            while (idx < n) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }
}