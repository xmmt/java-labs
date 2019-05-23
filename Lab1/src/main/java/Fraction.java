public class Fraction {
    private long m, n;

    Fraction(long m, long n) {
        this.m = m;
        this.n = n;
    }

    public long getNumerator() { return m; }

    public long getDenominator() { return n; }

    public void setNumerator(long m) { this.m = m; }

    public void setDenominator(long n) { this.n = n; }

    public boolean isLessThan(Fraction f) {
        return m * f.getNumerator() < n * f.getDenominator();
    }
}
