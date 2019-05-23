import java.util.List;

public class FractionSet {
    private List<Fraction> fractions;
    private Fraction maxFractionCached;
    private Fraction minFractionCached;
    private long countGreaterCached;
    private long countLessCached;
    private boolean maxFractionCachedIsRelevant = false;
    private boolean minFractionCachedIsRelevant = false;
    private boolean countGreaterCachedIsRelevant = false;
    private boolean countLessCachedIsRelevant = false;

    public void addFraction(Fraction f) {
        fractions.add(f);
        maxFractionCachedIsRelevant = false;
        minFractionCachedIsRelevant = false;
        countGreaterCachedIsRelevant = false;
        countLessCachedIsRelevant = false;
    }

    public Fraction getMaxFraction() {
        if (maxFractionCachedIsRelevant)
            return maxFractionCached;
        if (fractions.isEmpty())
            return null;
        maxFractionCached = fractions.get(0);
        for (Fraction i : fractions) {
            if (maxFractionCached.isLessThan(i))
                maxFractionCached = i;
        }
        maxFractionCachedIsRelevant = true;
        return maxFractionCached;
    }

    public Fraction getMinFraction() {
        if (minFractionCachedIsRelevant)
            return minFractionCached;
        if (fractions.isEmpty())
            return null;
        minFractionCached = fractions.get(0);
        for (Fraction i : fractions) {
            if (i.isLessThan(minFractionCached))
                minFractionCached = i;
        }
        minFractionCachedIsRelevant = true;
        return minFractionCached;
    }

    public long countOfFractionsGreaterThan(Fraction f) {
        if (countGreaterCachedIsRelevant)
            return countGreaterCached;
        countGreaterCached = 0;
        for (Fraction i : fractions) {
            if (f.isLessThan(i))
                 countGreaterCached++;
        }
        countGreaterCachedIsRelevant = true;
        return countGreaterCached;
    }

    public long countOfFractionsLessThan(Fraction f) {
        if (countLessCachedIsRelevant)
            return countLessCached;
        countLessCached = 0;
        for (Fraction i : fractions) {
            if (i.isLessThan(f))
                countLessCached++;
        }
        countLessCachedIsRelevant = true;
        return countLessCached;
    }
}
