import static java.lang.Math.abs;

public class Fraction implements Comparable<Fraction> {
    private long numerator, denominator;

    Fraction(long m, long n) {
        if (n == 0)
            throw new java.lang.IllegalArgumentException("Denominator can't be zero");
        if (n < 0) {
            m *= -1;
            n *= -1;
        }
        long g = gcd(abs(m), abs(n));
        this.numerator = m / g;
        this.denominator = n / g;
    }
    Fraction(long m) {
        this.numerator = m;
        this.denominator = 1;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            a %= b;
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return a;
    }

    public long numerator() { return numerator; }

    public long denominator() { return denominator; }

    public void setNumerator(long m) { this.numerator = m; }

    public void setDenominator(long n) { this.denominator = n; }

    public int compareTo(Fraction f) {
        long l = denominator * f.denominator() / gcd(denominator, f.denominator());
        long a = numerator * (l / f.denominator());
        long b = f.numerator() / (l / denominator);
        if (a > b)
            return 1;
        else if (a < b)
            return -1;
        else
            return 0;
    }

    public String toString() {
        return numerator + "/" + denominator;
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
        return (int)((numerator + denominator) ^ (numerator - denominator) ^ numerator * 73 ^ denominator * 37);
    }

    public Fraction add(Fraction f) {
        long l = denominator * f.denominator() / gcd(denominator, f.denominator());
        long a = numerator * (l / denominator());
        long b = f.numerator() * (l / f.denominator);
        return new Fraction(a + b, l);
    }
}
