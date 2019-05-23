public class Fraction implements Comparable<Fraction> {
    private long m, n;

    Fraction(long m, long n) {
        long g = gcd(m, n);
        this.m = m / g;
        this.n = n / g;
    }
    Fraction(long m) {
        this.m = m;
        this.n = 1;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            a %= b;
            a ^= b ^= a ^= b;
        }
        return a;
    }

    public long getNumerator() { return m; }

    public long getDenominator() { return n; }

    public void setNumerator(long m) { this.m = m; }

    public void setDenominator(long n) { this.n = n; }

    public int compareTo(Fraction o) {
        long l = n * o.n / gcd(n, o.n);
        long a = m * (l / o.n);
        long b = o.m / (l / n);
        if (a > b)
            return 1;
        else if (a < b)
            return -1;
        else
            return 0;
    }
}
