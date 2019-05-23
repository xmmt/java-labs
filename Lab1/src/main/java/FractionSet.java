import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class FractionSet {
    private List<Fraction> fractions = new ArrayList<Fraction>();
    private Fraction maxFractionCached;
    private Fraction minFractionCached;
    private boolean maxFractionCachedIsRelevant = false;
    private boolean minFractionCachedIsRelevant = false;
    private List<Pair<Fraction, Long>> countGreaterCached = new ArrayList<Pair<Fraction, Long>>();
    private List<Pair<Fraction, Long>> countLessCached = new ArrayList<Pair<Fraction, Long>>();

    public void addFraction(Fraction f) {
        fractions.add(f);
        maxFractionCachedIsRelevant = false;
        minFractionCachedIsRelevant = false;
        countGreaterCached.clear();
        countLessCached.clear();
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
        for (Pair<Fraction, Long> i : countGreaterCached)
            if (i.getKey().isEqual(f))
                return i.getValue();
        long result = 0;
        for (Fraction i : fractions) {
            if (f.isLessThan(i))
                 result++;
        }
        countGreaterCached.add(new Pair<Fraction, Long>(f, result));
        if (countGreaterCached.size() > 10)
            countGreaterCached.remove(0);
        return result;
    }

    public long countOfFractionsLessThan(Fraction f) {
        for (Pair<Fraction, Long> i : countLessCached)
            if (i.getKey().isEqual(f))
                return i.getValue();
        long result = 0;
        for (Fraction i : fractions) {
            if (i.isLessThan(f))
                result++;
        }
        countLessCached.add(new Pair<Fraction, Long>(f, result));
        if (countLessCached.size() > 10)
            countLessCached.remove(0);
        return result;
    }
}
