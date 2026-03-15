import java.util.*;

class Fancy {

    List<Long> seq;
    long add = 0;
    long mul = 1;
    final int MOD = 1_000_000_007;

    public Fancy() {
        seq = new ArrayList<>();
    }

    public void append(int val) {
        long v = (val - add + MOD) % MOD;
        v = (v * modInverse(mul)) % MOD;
        seq.add(v);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= seq.size())
            return -1;
        long val = seq.get(idx);
        return (int) ((val * mul % MOD + add) % MOD);
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long a, long b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}