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

    public int compareTo(Fraction f) {
        long l = n * f.getDenominator() / gcd(n, f.getDenominator());
        long a = m * (l / f.getDenominator());
        long b = f.getNumerator() / (l / n);
        if (a > b)
            return 1;
        else if (a < b)
            return -1;
        else
            return 0;
    }

    public String toString() {
        return m + " / " + n;
    }

    public boolean equals(Object f) {
        if (this == f)
            return true;
        if (f == null)
            return false;
        if (getClass() != f.getClass())
            return false;
        Fraction other = (Fraction) f;
        return compareTo(other) == 0;
    }

    public int hashCode() {
        return (int)((m + n) ^ (m - n) ^ m * 73 ^ n * 37);
    }

    public Fraction add(Fraction f) {
        long l = n * f.getDenominator() / gcd(n, f.getDenominator());
        long a = m * (l / f.getDenominator());
        long b = f.getNumerator() / (l / n);
        return new Fraction(a + b, l);
    }
}
